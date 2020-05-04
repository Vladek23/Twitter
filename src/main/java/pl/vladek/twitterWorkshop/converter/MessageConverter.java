package pl.vladek.twitterWorkshop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.vladek.twitterWorkshop.entity.Message;
import pl.vladek.twitterWorkshop.service.MessageService;

public class MessageConverter implements Converter<String, Message> {

    @Autowired
    private MessageService messageService;

    @Override
    public Message convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return messageService.loadById(id);
    }

}
