package dev.pavanetti.javaee7.chapter02;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        try (WeldContainer container = weld.initialize()) {
            BookService bookService = container.select(BookService.class).get();
            Book book = bookService.createBook("H2G2", 12.5f, "Geeky sci-fi Book");

            System.out.println(book);
        }
    }
}
