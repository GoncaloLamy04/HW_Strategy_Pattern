package dk.hw_stategy_pattern.controller;

import dk.hw_stategy_pattern.model.RegisterUserModel;
import dk.hw_stategy_pattern.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Viser registreringsformularen med et tomt model-objekt
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new RegisterUserModel());
        return "register";
    }

    // Modtager formularen, validerer og sender videre til success
    // Hvis validering fejler fanges det af GlobalExceptionHandler
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("user") RegisterUserModel user,
                                 @RequestParam(defaultValue = "simple") String mode,
                                 Model model) {
        userService.registerUser(user, mode);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "success";
    }
}
