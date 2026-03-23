package dk.hw_strategy_pattern.controller;

import dk.hw_strategy_pattern.model.RegisterUserModel;
import dk.hw_strategy_pattern.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

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
                                 @RequestParam(defaultValue = "simple") String mode) {
        userService.registerUser(user, mode);
        return "success";
    }
}