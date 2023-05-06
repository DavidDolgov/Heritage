package ru.netology.javaqa;

public class Book extends Product {
    private String author;


    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public boolean matches(Product product, String search) {
        if (super.matches(product, search) == false) {
            return getAuthor().contains(search);
        }
        return true;
    }
}
