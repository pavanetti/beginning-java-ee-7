package dev.pavanetti.javaee7.chapter03;

import jakarta.validation.Validation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressIT {
    @Test
    void shouldRaiseConstraintViolationCauseInvalidZipCode() {
        try (var validatorFactory = Validation.buildDefaultValidatorFactory()) {
            var validator = validatorFactory.getValidator();

            var address = ImmutableAddress.builder()
                    .street1("233 Spring Street")
                    .city("New York")
                    .state("NY")
                    .zipcode("DummyZip")
                    .country("USA")
                    .build();
            var violations = validator.validate(address);

            assertEquals(1, violations.size());
        }
    }
}
