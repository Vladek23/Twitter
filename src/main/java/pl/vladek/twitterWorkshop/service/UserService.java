package pl.vladek.twitterWorkshop.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.vladek.twitterWorkshop.entity.User;
import pl.vladek.twitterWorkshop.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public List<User> loadAll() {
        return userRepo.findAll();
    }

    public Optional<User> loadById(Long id) {
        return userRepo.findById(id);
    }

    public User loadByIdWithMessages(Long id) {
        User user = userRepo.getOne(id);
        Hibernate.initialize(user.getMessagesSent());
        Hibernate.initialize(user.getMessagesReceived());
        return user;
    }

    public User loadByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<User> loadAllUsersWithMessages() {
        List<User> allUsersWithMessages = userRepo.findAll();
        for (User user : allUsersWithMessages) {
            Hibernate.initialize(user.getMessagesReceived());
            Hibernate.initialize(user.getMessagesSent());
        }
        return allUsersWithMessages;
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    public boolean isExist(String email) {

        List<User> users = loadAll();
        if (users.size() != 0) {
            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    return true;
                }
            }
        }

        return false;
    }
}
