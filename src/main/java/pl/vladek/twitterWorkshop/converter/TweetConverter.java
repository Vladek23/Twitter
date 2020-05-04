package pl.vladek.twitterWorkshop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.vladek.twitterWorkshop.entity.Tweet;
import pl.vladek.twitterWorkshop.service.TweetService;

public class TweetConverter implements Converter<String, Tweet> {

    @Autowired
    private TweetService tweetService;

    @Override
    public Tweet convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return tweetService.loadById(id);
    }

}
