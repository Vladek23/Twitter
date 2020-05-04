package pl.vladek.twitterWorkshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MessageLabels")
public class MessageLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String color;

    @ManyToMany(mappedBy = "messageLabelList")
    private List<MessagePattern> messagePatterns = new ArrayList<>();

    public MessageLabel() {
    }

    public MessageLabel(String title, String description, String color) {
        this.title = title;
        this.description = description;
        this.color = color;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<MessagePattern> getMessagePatterns() {
        return messagePatterns;
    }

    public void setMessagePatterns(List<MessagePattern> messagePatterns) {
        this.messagePatterns = messagePatterns;
    }

    /** methods */

}
