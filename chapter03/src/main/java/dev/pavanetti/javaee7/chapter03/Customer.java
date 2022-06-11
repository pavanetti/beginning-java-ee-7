package dev.pavanetti.javaee7.chapter03;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.immutables.value.Value;

import java.time.LocalDate;
import java.util.Optional;

@Value.Immutable
public interface Customer {
    @NotNull @Size(min=2) String firstName();

    String lastName();

    @Email
    String email();

    Optional<String> phoneNumber();

    @Past LocalDate dateOfBirth();

    Optional<Address> deliveryAddress();

}
