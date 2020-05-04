package pl.vladek.twitterWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.vladek.twitterWorkshop.service.MessageUserPatternService;
import pl.vladek.twitterWorkshop.service.UserService;

@Controller
@RequestMapping("/messageUserPattern")
public class MessageUserPatternController {

    private UserService userService;
    private MessageUserPatternService messageUserPatternService;

    @Autowired
    public MessageUserPatternController(
            UserService userService,
            MessageUserPatternService messageUserPatternService
    ) {
        this.userService = userService;
        this.messageUserPatternService = messageUserPatternService;
    }

    @GetMapping("/{userId}")
    public String messageUserPatternsAll(
            @PathVariable Long userId,
            Model model
    ) {
        model.addAttribute("user", userService.loadById(userId));
        model.addAttribute("messageUserPatterns", messageUserPatternService.loadAll());
        return "messagePatterns/usersPatterns";
    }

}
