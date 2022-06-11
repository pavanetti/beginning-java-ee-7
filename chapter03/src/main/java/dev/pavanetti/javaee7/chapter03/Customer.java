package dev.pavanetti.javaee7.chapter03;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Customer {
    @NotNull
    @Size(min=2)
    private final String firstName;

    private final String lastName;

    @Email
    private final String email;

    private String phoneNumber;

    @Past
    private LocalDate dateOfBirth;

    private Address deliveryAddress;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
}
