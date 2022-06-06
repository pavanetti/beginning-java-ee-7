package dev.pavanetti.javaee7.chapter02;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookServiceIT {
    private WeldContainer container;

    @Before
    public void setUp() {
        Weld weld = new Weld();
        System.setProperty(Weld.ARCHIVE_ISOLATION_SYSTEM_PROPERTY, "false");
        this.container = weld.initialize();
    }

    @After
    public void tearDown() {
        this.container.shutdown();
    }

    @Test
    public void shouldCheckNumberIsMock() {
        BookService bookService = this.container.select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Geeky sci-fi Book");

        assertTrue(book.getNumber().startsWith("MOCK"));
    }
}
