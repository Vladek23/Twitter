package pl.vladek.twitterWorkshop.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.vladek.twitterWorkshop.entity.User;
import pl.vladek.twitterWorkshop.service.HomeService;
import pl.vladek.twitterWorkshop.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private UserService userService;
    private HomeService homeService;

    @Autowired
    public LoginController(
            UserService userService,
            HomeService homeService
    ) {
        this.userService = userService;
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            Model model, HttpSession session
    ) {
        model.addAttribute("isLogged", false);
        User user = userService.loadByEmail(email);
        if (user == null) {
            return "login";
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            model.addAttribute("isLogged", true);
            session.setAttribute("userSession", user);
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(
            HttpSession session
    ) {
        session.setAttribute("userSession", null);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(
            Model model
    ) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String register(
            @ModelAttribute("user")
            @Valid User user,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "registration";
        } else {
            userService.save(user);
        }
        return "redirect:/";
    }

}
