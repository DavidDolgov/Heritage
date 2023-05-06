package ru.netology.javaqa;

public class Product {
    protected int id;
    protected String name;
    protected int cost;

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return getName().contains(search);     // Возвращает true или false
    }
}
