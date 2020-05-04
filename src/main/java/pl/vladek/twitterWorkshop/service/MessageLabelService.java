package pl.vladek.twitterWorkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.vladek.twitterWorkshop.entity.MessageLabel;
import pl.vladek.twitterWorkshop.repository.MessageLabelRepository;

import java.util.List;

@Service
@Transactional
public class MessageLabelService {

    private MessageLabelRepository messageLabelRepo;

    @Autowired
    public MessageLabelService(MessageLabelRepository messageLabelRepo) {
        this.messageLabelRepo = messageLabelRepo;
    }

    public void save(MessageLabel messageLabel) {
        messageLabelRepo.save(messageLabel);
    }

    public MessageLabel loadById(Long id) {
        return messageLabelRepo.findById(id).get();
    }
    public List<MessageLabel> loadAll() {
        return messageLabelRepo.findAll();
    }


}