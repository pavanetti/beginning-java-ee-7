package dev.pavanetti.javaee7.chapter04;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookIT {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("chapter04TestPU");
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @BeforeEach
    void setUp() throws IllegalStateException {
        this.entityManager = BookIT.entityManagerFactory.createEntityManager();
        this.transaction = this.entityManager.getTransaction();
    }

    @AfterEach
    void tearDown() throws IllegalStateException {
        this.entityManager.close();
    }

    @Test
    void shouldFindBook() {
        var book = this.entityManager.find(Book.class, 1001L);
        assertNotNull(book);
        assertEquals("Beginning Java EE 7", book.getTitle());
    }

    @Test
    void shouldCreateH2G2Book() {
        var book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

        // Persists the book to the database
        this.transaction.begin();
        this.entityManager.persist(book);
        this.transaction.commit();
        assertNotNull(book.getId(), "ID should not be null");

        List<Book> books = this.entityManager
                .createNamedQuery("findBookByTitle", Book.class)
                .setParameter("title", "H2G2")
                .getResultList();
        assertEquals(1, books.size());
        assertEquals("The Hitchhiker's Guide to the Galaxy", books.get(0).getDescription());
    }

    @Test()
    void shouldRaiseConstraintViolationCauseNullTitle() {
        var book = new Book(null, "Null title, should fail", 12.5F, "1-84023-742-2", 354, false);

        this.transaction.begin();
        assertThrows(ConstraintViolationException.class, () -> {
            this.entityManager.persist(book);
            this.entityManager.flush();
        });
        this.transaction.commit();
    }
}
