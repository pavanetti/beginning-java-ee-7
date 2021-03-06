package dev.pavanetti.javaee7.chapter02;

import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;

import java.util.logging.Logger;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    @Override
    @Loggable
    public String generateNumber() {
        return "MOCK" + Math.random();
    }
}
