package dev.pavanetti.javaee7.chapter03;

import jakarta.validation.constraints.NotNull;

public class Address {
    @NotNull
    private final String street1;

    private String street2;

    @NotNull
    private final String city;

    private final String state;

    @NotNull
    @ZipCode
    private final String zipcode;

    private final String country;

    public Address(String street1, String city, String state, String zipcode, String country) {
        this.street1 = street1;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }
}
