package dev.pavanetti.javaee7.chapter02;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BookServiceIT {
    private WeldContainer container;

    @BeforeEach
    public void setUp() {
        Weld weld = new Weld();
        System.setProperty(Weld.ARCHIVE_ISOLATION_SYSTEM_PROPERTY, "false");
        this.container = weld.initialize();
    }

    @AfterEach
    public void tearDown() {
        this.container.shutdown();
    }

    @Test
    void shouldCheckNumberIsMock() {
        BookService bookService = this.container.select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Geeky sci-fi Book");

        assertTrue(book.getNumber().startsWith("MOCK"));
    }
}
