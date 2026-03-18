package dk.hw_strategy_pattern.validation;

import dk.hw_strategy_pattern.model.RegisterUserModel;

// Interface der definerer kontrakten for alle valideringsstrategier.
// Hver strategi skal implementere validate() og kaste ValidationException hvis input er ugyldigt.
public interface ValidationStrategy {

    void validate(RegisterUserModel model);
}
