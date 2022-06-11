package dev.pavanetti.javaee7.chapter03;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    @Inject
    @USA
    private ZipCodeChecker checker;
    private final Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        Matcher m = this.zipPattern.matcher(value);
        if (!m.matches()) return false;

        return this.checker.isZipCodeValid(value);
    }
}
