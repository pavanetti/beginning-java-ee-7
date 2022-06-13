package dev.pavanetti.javaee7.chapter04;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@NamedQuery(name="findAllBooks", query="SELECT b FROM Book b")
@NamedQuery(name="findBookByTitle", query="SELECT b FROM Book b WHERE b.title = :title")
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;
    private float price;
    @Size(min=10, max=2000)
    private String description;
    private String isbn;
    private int pages;
    private boolean illustrations;

    public Book() {
    }

    public Book(String title, String description, float price, String isbn, int pages, boolean illustrations) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.isbn = isbn;
        this.pages = pages;
        this.illustrations = illustrations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isIllustrations() {
        return illustrations;
    }

    public void setIllustrations(boolean illustrations) {
        this.illustrations = illustrations;
    }
}
