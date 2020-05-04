package pl.vladek.twitterWorkshop.entity;

import org.mindrot.jbcrypt.BCrypt;
import pl.vladek.twitterWorkshop.validator.UniqueEmail;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    @UniqueEmail
    @Email
    private String email;

    private String password;

    @OneToMany (mappedBy = "user")
    private List<Tweet> tweets = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany (mappedBy = "userAddressee")
    private List<Message> messagesReceived = new ArrayList<>();

    @OneToMany(mappedBy = "userSender")
    private List<Message> messagesSent = new ArrayList<>();

    @OneToMany(mappedBy = "userSender")
    private List<MessageUserPattern> messageUserPatterns = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.setPassword(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
//        this.password = password;
        this.password = hashPassword(password);
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(List<Message> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    public List<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(List<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }

    public List<MessageUserPattern> getMessageUserPatterns() {
        return messageUserPatterns;
    }

    public void setMessageUserPatterns(List<MessageUserPattern> messageUserPatterns) {
        this.messageUserPatterns = messageUserPatterns;
    }

    private String hashPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }

}