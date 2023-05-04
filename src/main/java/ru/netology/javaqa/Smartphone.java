package ru.netology.javaqa;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone (int id, String name, int cost, String manufacturer) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean matches(Product product, String search) {
        if (super.matches(product, search) == false) {
            return getManufacturer().contains(search);
        }
        return true;
    }
}
