package dev.pavanetti.javaee7.chapter02;

import jakarta.inject.Inject;

import java.util.Random;
import java.util.logging.Logger;

@EightDigits
public class IssnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    private final Random random = new Random();

    @Override
    @Loggable
    public String generateNumber() {
        String issn = "8-" + Math.abs(random.nextInt() + 1);
        logger.info("Generated ISBN : " + issn);
        return issn;
    }
}
