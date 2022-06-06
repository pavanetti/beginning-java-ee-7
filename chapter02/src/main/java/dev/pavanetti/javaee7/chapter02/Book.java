package dev.pavanetti.javaee7.chapter02;

public class Book {
    private final String title;
    private final float price;
    private final String description;
    private final String number;

    // ======================================
    // =            Constructors            =
    // ======================================
    public Book(String title, float price, String description, String number) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.number = number;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getNumber() {
        return number;
    }

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
