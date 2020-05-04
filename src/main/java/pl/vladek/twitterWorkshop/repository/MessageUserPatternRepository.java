package pl.vladek.twitterWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vladek.twitterWorkshop.entity.MessageUserPattern;

public interface MessageUserPatternRepository extends JpaRepository<MessageUserPattern, Long> {
}
