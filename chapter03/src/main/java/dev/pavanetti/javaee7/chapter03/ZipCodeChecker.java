package dev.pavanetti.javaee7.chapter03;

public class ZipCodeChecker {
    public boolean isZipCodeValid(String zipCode) {
        // Call an external web service to check zipcode
        return zipCode.length() == 5;
    }
}
