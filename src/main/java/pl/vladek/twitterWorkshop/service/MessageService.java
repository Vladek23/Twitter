package pl.vladek.twitterWorkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.vladek.twitterWorkshop.entity.Message;
import pl.vladek.twitterWorkshop.repository.MessageRepository;

@Service
@Transactional
public class MessageService {

    private MessageRepository messageRepo;

    @Autowired
    public MessageService(MessageRepository messageRepo) {
        this.messageRepo = messageRepo;
    }

    public void save(Message message) {
        messageRepo.save(message);
    }

    public Message loadById(Long id) {
        return messageRepo.findById(id).get();
    }

}

