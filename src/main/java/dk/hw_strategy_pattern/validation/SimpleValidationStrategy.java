package dk.hw_strategy_pattern.validation;

import dk.hw_strategy_pattern.exception.ValidationException;
import dk.hw_strategy_pattern.model.RegisterUserModel;

import java.util.ArrayList;
import java.util.List;

// Simpel valideringsstrategi med grundlæggende krav til input
public class SimpleValidationStrategy implements ValidationStrategy{

    @Override
    public void validate(RegisterUserModel model) {
        List<String> fejl = new ArrayList<>();

        if (model.getUsername() == null || model.getUsername().length() < 3) {
            fejl.add("Username skal være mindst 3 tegn");
        }

        if (model.getEmail() == null || !model.getEmail().contains("@") || !model.getEmail().contains(".")) {
            fejl.add("Email skal indeholde @ og et punktum");
        }

        if (model.getPassword() == null || model.getPassword().length() < 6) {
            fejl.add("Password skal mindst have 6 tegn");
        }

        if (!fejl.isEmpty()){
            throw new ValidationException(fejl);
        }
    }
}

