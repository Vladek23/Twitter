package pl.vladek.twitterWorkshop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.vladek.twitterWorkshop.entity.Comment;
import pl.vladek.twitterWorkshop.service.CommentService;

public class CommentConverter implements Converter<String, Comment> {

    @Autowired
    CommentService commentService;

    @Override
    public Comment convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        return commentService.loadById(Long.parseLong(s));
    }

}
