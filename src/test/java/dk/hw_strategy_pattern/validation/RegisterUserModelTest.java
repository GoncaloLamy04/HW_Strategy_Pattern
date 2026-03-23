package dk.hw_strategy_pattern.validation;

import dk.hw_strategy_pattern.model.RegisterUserModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegisterUserModelTest {

    @Test
    void toStringSkalSkjulePassword() {
        RegisterUserModel model = new RegisterUserModel();
        model.setUsername("nicki");
        model.setEmail("nicki@test.dk");
        model.setPassword("secret123");

        String result = model.toString();

        assertTrue(result.contains("[hidden]"));
        assertFalse(result.contains("secret123"));
    }
}
