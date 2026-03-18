package dk.hw_strategy_pattern.validation;

import dk.hw_strategy_pattern.exception.ValidationException;
import dk.hw_strategy_pattern.model.RegisterUserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StrictValidationStrategyTest {

    private StrictValidationStrategy strategy;
    private RegisterUserModel model;

    @BeforeEach
    void setup(){
        strategy = new StrictValidationStrategy();
        model = new RegisterUserModel();
    }

    @Test
    void InputGiverIngenException(){
        model.setUsername("yourmum");
        model.setPassword("IDontlikeSceneBuilder777");
        model.setEmail("goncalo@gmail.com");

        assertDoesNotThrow(() -> strategy.validate(model));
    }


    @Test
    void usernameTegnTjek() {
        model.setUsername("½½½erwrwr½½½");
        model.setPassword("asdsdfsdf234234");
        model.setEmail("goncalo@gmail.com");

        assertDoesNotThrow(()-> strategy.validate(model) );

    }

    @Test
    void forKortPassword(){
        model.setUsername("goncalo");
        model.setPassword("be");
        model.setEmail("goncalo@gmail.com");

        ValidationException ex = assertThrows(ValidationException.class, () -> strategy.validate(model));
        assertEquals("Password skal indeholde tal og bogstaver!", ex.getMessage());
    }

    @Test
    void nullPassword(){
        model.setUsername("goncalo666");
        model.setPassword("");
        model.setEmail("goncalo@gmail.com");

        ValidationException ex = assertThrows(ValidationException.class, () -> strategy.validate(model));
        assertEquals("Password skal indeholde tal og bogstaver!", ex.getMessage());

    }


}
