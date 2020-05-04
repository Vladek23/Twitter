package pl.vladek.twitterWorkshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "Tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Size(min = 1, max = 140, message = "1-140 chars.")
    private String text;

    private LocalDateTime created;

    @OneToMany (mappedBy = "tweet")
    private List<Comment> comments = new ArrayList<>();

    public Tweet() {
    }

    public Tweet(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.getComments().add(comment);
    }

    @PrePersist
    public void prePersist() {
        this.setCreated(LocalDateTime.now());
    }

}
