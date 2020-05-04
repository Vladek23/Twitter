package pl.vladek.twitterWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vladek.twitterWorkshop.entity.MessagePattern;

public interface MessagePatternRepository extends JpaRepository<MessagePattern, Long> {
}
