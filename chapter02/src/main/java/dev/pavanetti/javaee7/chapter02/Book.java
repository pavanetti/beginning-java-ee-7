package dev.pavanetti.javaee7.chapter02;

import org.immutables.value.Value;

@Value.Immutable
public interface Book {
    String title();

    float price();

    String description();

    String number();
}

