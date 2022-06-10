package dev.pavanetti.javaee7.chapter02;

import jakarta.inject.Inject;

import java.util.Random;
import java.util.logging.Logger;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    private final Random random = new Random();

    @Override
    @Loggable
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(this.random.nextInt() + 1);
        logger.info("Generated ISBN : " + isbn);
        return isbn;
    }
}

