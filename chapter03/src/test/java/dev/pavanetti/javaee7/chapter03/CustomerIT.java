package dev.pavanetti.javaee7.chapter03;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerIT {
    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        CustomerIT.factory = Validation.buildDefaultValidatorFactory();
        CustomerIT.validator = CustomerIT.factory.getValidator();
    }

    @AfterAll
    public static void tearDown() {
        CustomerIT.factory.close();
    }

    @Test
    void shouldRaiseNoConstraintViolation() {
        var customer = ImmutableCustomer.builder()
                .firstName("John")
                .lastName("Doe")
                .email("jdoe@email.com")
                .dateOfBirth(LocalDate.of(1980, 1, 1))
                .build();
        var violations = CustomerIT.validator.validate(customer);
        assertEquals(0, violations.size());
    }

    @Test
    void shouldRaiseConstraintViolationCauseInvalidEmail() {
        var customer = ImmutableCustomer.builder()
                .firstName("John")
                .lastName("Doe")
                .email("dummyEmail")
                .dateOfBirth(LocalDate.of(1980, 1, 1))
                .build();
        var violations = CustomerIT.validator.validate(customer);

        assertEquals(1, violations.size());
        var violation = violations.iterator().next();
        assertEquals("invalid email address", violation.getMessage());
        assertEquals("dummyEmail", violation.getInvalidValue());
        assertEquals("{dev.pavanetti.javaee7.chapter03.Email.message}", violation.getMessageTemplate());
    }
}
