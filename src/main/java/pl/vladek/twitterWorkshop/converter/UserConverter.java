package pl.vladek.twitterWorkshop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.vladek.twitterWorkshop.entity.User;
import pl.vladek.twitterWorkshop.service.UserService;

public class UserConverter implements Converter<String, User> {

    @Autowired
    private UserService userService;

    @Override
    public User convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return userService.loadById(id).get();
    }

}
