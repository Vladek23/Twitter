package pl.vladek.twitterWorkshop.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.vladek.twitterWorkshop.entity.MessageUserPattern;
import pl.vladek.twitterWorkshop.repository.MessageUserPatternRepository;

import java.util.List;

@Service
@Transactional
public class MessageUserPatternService {

    private MessageUserPatternRepository messageUserPatternRepo;

    @Autowired
    public MessageUserPatternService(MessageUserPatternRepository messageUserPatternRepo) {
        this.messageUserPatternRepo = messageUserPatternRepo;
    }

    public void save(MessageUserPattern messageUserPattern) {
        messageUserPatternRepo.save(messageUserPattern);
    }

    public List<MessageUserPattern> loadAll() {
        List<MessageUserPattern> messageUserPatternList = messageUserPatternRepo.findAll();
        for (MessageUserPattern messageUserPattern : messageUserPatternList) {
            Hibernate.initialize(messageUserPattern.getMessageLabelList());
        }
        return messageUserPatternList;
    }

}
