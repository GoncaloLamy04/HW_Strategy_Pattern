package dk.hw_stategy_pattern.validation;

import dk.hw_stategy_pattern.exception.ValidationException;
import dk.hw_stategy_pattern.model.RegisterUserModel;

import java.util.ArrayList;
import java.util.List;

// Streng valderingsstrategi med skrappere krav til input
public class StrictValidationStrategy implements ValidationStrategy {

    @Override
    public void validate(RegisterUserModel model) {
        List<String> fejl = new ArrayList<>();

        if (model.getUsername() == null || model.getUsername().length() < 6 || model.getUsername().contains(" ")) {
            fejl.add("Username skal være mindst 6 tegn og må ikke indeholde mellemrum");
        }
        if (model.getEmail() == null || !model.getEmail().matches(".+@.+\\..+")) {
            fejl.add("Email skal indeholde @ og . !");
        }
        if (model.getPassword() == null || model.getPassword().length() < 10
                || !model.getPassword().matches(".*[0-9].*")
                || !model.getPassword().matches(".*[a-zA-Z].*")) {
            fejl.add("Password skal indeholde tal og bogstaver!");
        }

        if (!fejl.isEmpty()){
            throw new ValidationException(fejl);
        }
    }
}
