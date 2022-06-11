package dev.pavanetti.javaee7.chapter02;

import jakarta.inject.Inject;

public class BookService {
    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, float price, String description) {
        return ImmutableBook.builder()
                .title(title)
                .price(price)
                .description(description)
                .number(this.numberGenerator.generateNumber())
                .build();
    }
}
