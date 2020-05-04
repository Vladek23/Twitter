package pl.vladek.twitterWorkshop.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.vladek.twitterWorkshop.entity.MessagePattern;
import pl.vladek.twitterWorkshop.repository.MessagePatternRepository;

import java.util.List;

@Service
@Transactional
public class MessagePatternService {

    private MessagePatternRepository messagePatternRepo;

    @Autowired
    public MessagePatternService(MessagePatternRepository messagePatternRepo) {
        this.messagePatternRepo = messagePatternRepo;
    }

    public void save(MessagePattern messagePattern) {
        messagePatternRepo.save(messagePattern);
    }

    public MessagePattern loadById(Long id) {
        return messagePatternRepo.findById(id).get();
    }

    public List<MessagePattern> loadAll() {
        List<MessagePattern> messagePatterns = messagePatternRepo.findAll();
        for (MessagePattern messagePattern : messagePatterns) {
            Hibernate.initialize(messagePattern.getMessageLabelList());
        }
        return messagePatterns;
    }
}