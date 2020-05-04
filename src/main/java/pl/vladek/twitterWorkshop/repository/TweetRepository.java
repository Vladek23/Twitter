package pl.vladek.twitterWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.vladek.twitterWorkshop.entity.Tweet;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

//    List<Tweet> findAllOrderByCreatedDesc();
//    List<Tweet> findAllByIdOrderByCreatedDesc();

    @Query(value = "SELECT * FROM Tweet ORDER BY created DESC LIMIT 5", nativeQuery = true)
    List<Tweet> findAllOrderByCreatedDescLimit5();

}
