package pl.vladek.twitterWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.vladek.twitterWorkshop.entity.MessagePattern;
import pl.vladek.twitterWorkshop.entity.MessageUserPattern;
import pl.vladek.twitterWorkshop.service.MessagePatternService;
import pl.vladek.twitterWorkshop.service.MessageUserPatternService;
import pl.vladek.twitterWorkshop.service.UserService;

@Controller
@RequestMapping("/messagePatterns")
public class MessagePatternController {

    private MessagePatternService messagePatternService;
    private UserService userService;
    private MessageUserPatternService messageUserPatternService;

    @Autowired
    public MessagePatternController(
            MessagePatternService messagePatternService,
            UserService userService,
            MessageUserPatternService messageUserPatternService
    ) {
        this.messagePatternService = messagePatternService;
        this.userService = userService;
        this.messageUserPatternService = messageUserPatternService;
    }

    @GetMapping("/all")
    public String all(
            Model model
    ) {
        model.addAttribute("messagePatterns", messagePatternService.loadAll());
        return "/messagePatterns/all";
    }

    @GetMapping("/messagePattern/{userSessionId}/download/{messagePatternId}")
    public String downloadMessagePattern(
            @PathVariable("userSessionId") Long userId,
            @PathVariable("messagePatternId") Long messagePatternId
    ) {
        MessagePattern messagePatternToDownload = messagePatternService.loadById(messagePatternId);
        MessageUserPattern messageUserPattern = new MessageUserPattern(messagePatternToDownload, userService.loadById(userId).get());
        messageUserPatternService.save(messageUserPattern);
        return "redirect:/messageUserPattern/"+userId;
    }

}
