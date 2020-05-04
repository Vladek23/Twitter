package pl.vladek.twitterWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.vladek.twitterWorkshop.entity.Tweet;
import pl.vladek.twitterWorkshop.entity.User;
import pl.vladek.twitterWorkshop.service.HomeService;
import pl.vladek.twitterWorkshop.service.TweetService;
import pl.vladek.twitterWorkshop.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    private HomeService homeService;
    private TweetService tweetService;
    private UserService userService;

    @Autowired
    public HomeController(
            HomeService homeService,
            TweetService tweetService,
            UserService userService
    ) {
        this.homeService = homeService;
        this.tweetService = tweetService;
        this.userService = userService;
    }

    @ModelAttribute("allTweets")
    public List<Tweet> allTweets() {
//        return tweetService.loadAll();
        return tweetService.loadAllOrderByCreatedDescLimit5();
    }

    @ModelAttribute("allUsers")
    public List<User> allUsers() {
        return userService.loadAll();
    }

    @GetMapping("/startTestDB")
    public String startTestDb() {
        homeService.startTestDB();
        return "redirect:/";
    }

    @GetMapping("/home")
    public String home(
            Model model
    ) {
        model.addAttribute("tweet", new Tweet());
        return "home";
    }

    @PostMapping("/home")
    public String homeSaveTweet(
            @ModelAttribute("tweet")
            @Valid Tweet tweet,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "home";
        }
        tweetService.save(tweet);
        return "redirect:/home";
    }

}
