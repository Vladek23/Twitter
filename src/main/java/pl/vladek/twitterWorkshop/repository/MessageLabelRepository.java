package pl.vladek.twitterWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vladek.twitterWorkshop.entity.MessageLabel;

public interface MessageLabelRepository extends JpaRepository<MessageLabel, Long> {
}