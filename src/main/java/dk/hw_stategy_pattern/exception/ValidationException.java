package dk.hw_stategy_pattern.exception;

import org.jspecify.annotations.Nullable;

import java.util.List;

// Custom exception der kastes når validering fejler
// Extender RuntimeException så vi ikke behøver at deklarere den med throws
public class ValidationException extends RuntimeException {

    private final List<String> fejl;

    public ValidationException(List<String> fejl) {
        super(String.join(", ", fejl));
        this.fejl = fejl;
    }

    public List<String> getFejl() {
        return fejl;
    }
}
