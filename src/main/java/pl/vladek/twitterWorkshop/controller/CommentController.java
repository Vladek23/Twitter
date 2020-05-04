package pl.vladek.twitterWorkshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.vladek.twitterWorkshop.entity.Comment;
import pl.vladek.twitterWorkshop.entity.Tweet;
import pl.vladek.twitterWorkshop.entity.User;
import pl.vladek.twitterWorkshop.service.CommentService;
import pl.vladek.twitterWorkshop.service.TweetService;
import pl.vladek.twitterWorkshop.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private TweetService tweetService;
    private CommentService commentService;
    private UserService userService;

    public CommentController(
            TweetService tweetService,
            CommentService commentService,
            UserService userService
    ) {
        this.tweetService = tweetService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @ModelAttribute("allUsers")
    public List<User> getAllUsers() {
        return userService.loadAll();
    }

    @GetMapping("/tweet-{id}/all")
    public String getCommentsByTweetId(
            @PathVariable Long id,
            Model model
    ) {
        Tweet tweet = tweetService.loadById(id);
        List<Comment> comments = commentService.loadAllByTweet(tweet);
        model.addAttribute("tweet", tweet);
        model.addAttribute("comments", comments);
        return "/comments/byTweet/all";
    }

    @GetMapping("/tweet-{id}/create")
    public String createCommentForTweet(
            @PathVariable Long id,
            Model model
    ) {
        Tweet tweet = tweetService.loadByIdWithComments(id);
        Comment comment = new Comment(tweet);
        model.addAttribute("comment", comment);
        return "/comments/byTweet/create";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute("comment") Comment comment
    ) {
        commentService.save(comment);
        return "redirect:/";
    }

}
