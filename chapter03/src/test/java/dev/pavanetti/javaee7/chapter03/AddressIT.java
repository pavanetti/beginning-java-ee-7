package dev.pavanetti.javaee7.chapter03;

import jakarta.validation.Validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressIT {
    void shouldRaiseConstraintViolationCauseInvalidZipCode() {
        try (var validatorFactory = Validation.buildDefaultValidatorFactory()) {
            var validator = validatorFactory.getValidator();

            var address = new Address("233 Spring Street", "New York", "NY", "DummyZip", "USA");
            var violations = validator.validate(address);

            assertEquals(1, violations.size());
        }
    }
}
