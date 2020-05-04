package pl.vladek.twitterWorkshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MessagePatterns")
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MessagePattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    @ManyToMany
    @JoinTable(name = "MessagePatterns_MessageLabels",
            joinColumns = @JoinColumn(name = "MessagePattern_id"),
            inverseJoinColumns = @JoinColumn(name = "MessageLabel_id")
    )
    private List<MessageLabel> messageLabelList = new ArrayList<>();

    public MessagePattern() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MessageLabel> getMessageLabelList() {
        return messageLabelList;
    }

    public void setMessageLabelList(List<MessageLabel> messageLabelList) {
        this.messageLabelList = messageLabelList;
    }

    public void addMessageLabel(MessageLabel messageLabel) {
        this.messageLabelList.add(messageLabel);
    }
    public void removeMessageLabel(MessageLabel messageLabel) {
        this.messageLabelList.remove(messageLabel);
    }


}
