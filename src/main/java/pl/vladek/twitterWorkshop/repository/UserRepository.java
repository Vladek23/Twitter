package pl.vladek.twitterWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vladek.twitterWorkshop.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}