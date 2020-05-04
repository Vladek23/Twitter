package pl.vladek.twitterWorkshop.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.vladek.twitterWorkshop.entity.Tweet;
import pl.vladek.twitterWorkshop.repository.TweetRepository;

import java.util.List;

@Service
@Transactional
public class TweetService {

    private TweetRepository tweetRepo;

    @Autowired

    public TweetService(TweetRepository tweetRepo) {
        this.tweetRepo = tweetRepo;
    }

    public void save(Tweet tweet) {
        tweetRepo.save(tweet);
    }

    public List<Tweet> loadAll() {
        return tweetRepo.findAll();
    }

    public List<Tweet> loadAllOrderByCreatedDescLimit5() {
        return tweetRepo.findAllOrderByCreatedDescLimit5();
    }

    public Tweet loadById(Long id) {
        return tweetRepo.findById(id).get();
    }

    public Tweet loadByIdWithComments(Long id) {
        Tweet tweet = tweetRepo.getOne(id);
        Hibernate.initialize(tweet.getComments());
        return tweet;
    }

    public void delete(Tweet tweet) {
        tweetRepo.delete(tweet);
    }
}
