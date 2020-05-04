package pl.vladek.twitterWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vladek.twitterWorkshop.entity.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {
}
