package pl.vladek.twitterWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.vladek.twitterWorkshop.entity.Message;
import pl.vladek.twitterWorkshop.entity.User;
import pl.vladek.twitterWorkshop.service.MessagePatternService;
import pl.vladek.twitterWorkshop.service.MessageService;
import pl.vladek.twitterWorkshop.service.UserService;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private MessageService messageService;
    private UserService userService;
    private MessagePatternService messagePatternService;

    @Autowired
    public MessageController(
            MessageService messageService,
            UserService userService,
            MessagePatternService messagePatternService
    ) {
        this.messageService = messageService;
        this.userService = userService;
        this.messagePatternService = messagePatternService;
    }

    @GetMapping("/messagebox/{id}")
    public String messagebox(
            @PathVariable Long id,
            Model model
    ) {
        User user = userService.loadByIdWithMessages(id);
        model.addAttribute("user", user);
        return "/messages/messagebox";
    }

    @GetMapping("/send/{idSender}/{idAddressee}")
    public String sendMessage(
            @PathVariable Long idSender,
            @PathVariable Long idAddressee,
            Model model
    ) {
        User userSender = userService.loadById(idSender).get();
        User userAddressee = userService.loadById(idAddressee).get();
        model.addAttribute("userSender", userSender);
        model.addAttribute("userAddressee", userAddressee);
        model.addAttribute("message", new Message(userSender, userAddressee));
        return "/messages/new";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(
            @ModelAttribute("message") Message message
    ) {
        messageService.save(message);
        return "redirect:/messages/messagebox/"+message.getUserSender().getId();
    }


}
