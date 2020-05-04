package pl.vladek.twitterWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.vladek.twitterWorkshop.entity.MessageLabel;
import pl.vladek.twitterWorkshop.service.MessageLabelService;

@Controller
@RequestMapping("/messageLabels")
public class MessageLabelController {

    private MessageLabelService messageLabelService;

    @Autowired
    public MessageLabelController(MessageLabelService messageLabelService) {
        this.messageLabelService = messageLabelService;
    }

    @GetMapping("/create")
    public String create(
            Model model
    ) {
        MessageLabel messageLabel = new MessageLabel();
        model.addAttribute("messageLabel", messageLabel);
        return ("/messageLabels/create");
    }
    @PostMapping("/create")
    public String save(
            @ModelAttribute MessageLabel messageLabel
    ) {
        messageLabelService.save(messageLabel);
        return "redirect:/messageLabels/all";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("messageLabelsAll", messageLabelService.loadAll());
        return "messageLabels/all";
    }

}