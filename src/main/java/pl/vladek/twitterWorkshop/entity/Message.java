package pl.vladek.twitterWorkshop.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User userSender;

    @ManyToOne
    private User userAddressee;

    private String text;

    private LocalDateTime created;

    private Boolean isRead = false;

    public Message() {
    }

    public Message(User userSender, User userAddressee) {
        this.userSender = userSender;
        this.userAddressee = userAddressee;
    }

    public Message(User userSender, User userAddressee, String text) {
        this.userSender = userSender;
        this.userAddressee = userAddressee;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public User getUserAddressee() {
        return userAddressee;
    }

    public void setUserAddressee(User userAddressee) {
        this.userAddressee = userAddressee;
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

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    @PrePersist
    public void prePersist() {
        this.setCreated(LocalDateTime.now());
    }

}
