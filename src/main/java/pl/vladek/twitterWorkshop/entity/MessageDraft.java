package pl.vladek.twitterWorkshop.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MessageDraft extends MessagePattern {

    @ManyToOne
    private User userSender;

}

