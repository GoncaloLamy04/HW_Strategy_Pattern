package dk.hw_strategy_pattern.service;

import dk.hw_strategy_pattern.model.RegisterUserModel;
import dk.hw_strategy_pattern.validation.SimpleValidationStrategy;
import dk.hw_strategy_pattern.validation.StrictValidationStrategy;
import dk.hw_strategy_pattern.validation.ValidationStrategy;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Strategierne oprettes ét sted som felter i stedet for inde i metoden hver gang
    // Det gør UserService mere tydeligt koblet til interfacet ValidationStrategy
    private final ValidationStrategy simpleStrategy = new SimpleValidationStrategy();
    private final ValidationStrategy strictStrategy = new StrictValidationStrategy();

    public void registerUser(RegisterUserModel model, String mode) {
        ValidationStrategy strategy = getStrategy(mode);
        strategy.validate(model);
    }

    // Returnerer den rigtige strategi baseret på mode
    // Kaster IllegalArgumentException ved ukendt mode i stedet for at falde tilbage til simple
    private ValidationStrategy getStrategy(String mode) {
        if ("simple".equals(mode)) {
            return simpleStrategy;
        } else if ("strict".equals(mode)) {
            return strictStrategy;
        }
        throw new IllegalArgumentException("Ukendt valideringstype: " + mode);
    }
}