package dev.pavanetti.javaee7.chapter04;

import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        var book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F,
                "1-84023-742-2", 354, false);

        var factory = Persistence.createEntityManagerFactory("chapter04PU");
        var entityManager = factory.createEntityManager();

        var tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(book);
        tx.commit();

        var newBook = entityManager
                .createNamedQuery("findBookByTitle", Book.class)
                .setParameter("title", "H2G2")
                .getSingleResult();

        System.out.println("######### " + newBook.getDescription());

        entityManager.close();
        factory.close();

    }
}
