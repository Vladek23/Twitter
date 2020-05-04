package pl.vladek.twitterWorkshop.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MessageUserPatterns")
//@AttributeOverrides({
//        @AttributeOverride(name="id", column = @Column(name = "id")),
//        @AttributeOverride(name="title", column = @Column(name = "titlle")),
//        @AttributeOverride(name = "text", column = @Column(name = "text")),
//        @AttributeOverride(name = "messageLabelList", column = @Column(name = "messageLabelList"))
//})
public class MessageUserPattern extends MessagePattern {

    @ManyToOne
    private User userSender;

    public MessageUserPattern(User userSender) {
        this.userSender = userSender;
    }

    public MessageUserPattern(MessagePattern messagePattern, User userSender) {
        this.setTitle(messagePattern.getTitle());
        this.setText(messagePattern.getText());
        this.setMessageLabelList(messagePattern.getMessageLabelList());
        this.setUserSender(userSender);
    }

    public MessageUserPattern() {
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

}
