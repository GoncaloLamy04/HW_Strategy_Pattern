package dk.hw_stategy_pattern.validation;

import dk.hw_stategy_pattern.exception.ValidationException;
import dk.hw_stategy_pattern.model.RegisterUserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleValidationStrategyTest {

    private SimpleValidationStrategy strategy;
    private RegisterUserModel model;

    @BeforeEach
    void setUp() {
        strategy = new SimpleValidationStrategy();
        model = new RegisterUserModel();
    }

    @Test
    void gyldigtInputGiverIngenException() {
        model.setUsername("nicki");
        model.setEmail("nicki@test.dk");
        model.setPassword("secret123");

        assertDoesNotThrow(() -> strategy.validate(model));
    }

    @Test
    void forKortUsernavnKasterException() {
        model.setUsername("ni");
        model.setEmail("nicki@test.dk");
        model.setPassword("secret123");

        ValidationException ex = assertThrows(ValidationException.class, () -> strategy.validate(model));
        assertEquals("Username skal være mindst 3 tegn!", ex.getMessage());
    }

    @Test
    void emailUdenSnabelAKasterException() {
        model.setUsername("nicki");
        model.setEmail("nickitest.dk");
        model.setPassword("secret123");

        ValidationException ex = assertThrows(ValidationException.class, () -> strategy.validate(model));
        assertEquals("Email skal indeholde @ og et punktum", ex.getMessage());
    }

    @Test
    void forKortPasswordKasterException() {
        model.setUsername("nicki");
        model.setEmail("nicki@test.dk");
        model.setPassword("abc");

        ValidationException ex = assertThrows(ValidationException.class, () -> strategy.validate(model));
        assertEquals("Password skal mindst have 6 tegn!", ex.getMessage());
    }

    @Test
    void nullUsernameKasterException() {
        model.setUsername(null);
        model.setEmail("nicki@test.dk");
        model.setPassword("secret123");

        ValidationException ex = assertThrows(ValidationException.class, () -> strategy.validate(model));
        assertEquals("Username skal være mindst 3 tegn!", ex.getMessage());
    }
}