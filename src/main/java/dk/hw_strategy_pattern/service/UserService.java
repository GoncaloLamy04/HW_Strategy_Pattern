package dk.hw_strategy_pattern.service;

import dk.hw_strategy_pattern.model.RegisterUserModel;
import dk.hw_strategy_pattern.validation.SimpleValidationStrategy;
import dk.hw_strategy_pattern.validation.StrictValidationStrategy;
import dk.hw_strategy_pattern.validation.ValidationStrategy;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Vælger strategi baseret på mode og køre validering
    public void registerUser(RegisterUserModel model, String mode) {
        ValidationStrategy strategy = getStrategey(mode);
        strategy.validate(model);
    }

    // Returnere den rigtige strategi baseret på mode
    private ValidationStrategy getStrategey(String mode) {
        if ("strict".equals(mode)) {
            return new StrictValidationStrategy();
        }
        return new SimpleValidationStrategy();
    }
}
