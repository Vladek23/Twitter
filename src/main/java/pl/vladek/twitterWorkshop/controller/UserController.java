package pl.vladek.twitterWorkshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.vladek.twitterWorkshop.entity.User;
import pl.vladek.twitterWorkshop.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @ModelAttribute("allUsers")
    public List<User> getAllUsers() {
        return userService.loadAll();
    }
    @ModelAttribute("allUsersWithMessages")
    public List<User> getAllUsersWithMessages() {
        return userService.loadAllUsersWithMessages();
    }

    @GetMapping("/all")
    public String usersAll() {
        return "/users/all";
    }
}
