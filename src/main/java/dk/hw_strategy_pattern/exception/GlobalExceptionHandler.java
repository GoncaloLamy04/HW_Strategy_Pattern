package dk.hw_strategy_pattern.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Centralt sted der fanger exceptions fra alle controllere
// Så vi ikke behøver try-catch i controlleren
@ControllerAdvice
public class GlobalExceptionHandler {

    // Fanger ValidationException og viser error-siden med en brugervenlig besked
    @ExceptionHandler(ValidationException.class)
    public String handleValidationException(ValidationException ex, Model model){
        model.addAttribute("fejl", ex.getFejl());
        return "error";
    }
}
