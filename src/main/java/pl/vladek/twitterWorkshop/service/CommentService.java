package pl.vladek.twitterWorkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.vladek.twitterWorkshop.entity.Comment;
import pl.vladek.twitterWorkshop.entity.Tweet;
import pl.vladek.twitterWorkshop.repository.CommentRepository;

import java.util.List;

@Service
@Transactional
public class CommentService {

    private CommentRepository commentRepo;

    @Autowired
    public CommentService(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    public List<Comment> loadAllByTweet(Tweet tweet) {
        return commentRepo.findAllByTweet(tweet);
    }

    public Comment loadById(Long id) {
        return commentRepo.findById(id).get();
    }

}
