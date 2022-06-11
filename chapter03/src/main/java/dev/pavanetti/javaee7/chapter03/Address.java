package dev.pavanetti.javaee7.chapter03;

import jakarta.validation.constraints.NotNull;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public interface Address {
    @NotNull String street1();

    Optional<String> street2();

    @NotNull String city();

    String state();

    @NotNull
    @ZipCode
    String zipcode();

    String country();

}
