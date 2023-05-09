package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SaveByIdTests {

    Product product1 = new Book(1, "Book 1", 100, "Author 1");
    Product product2 = new Book(2, "Book 2", 200, "Author 2");
    Product product3 = new Book(3, "Book 3", 300, "Author 3");
    Product product4 = new Book(4, "Book 4", 400, "Author 4");
    Product product5 = new Book(5, "Book 5", 500, "Author 5");
    Product product6 = new Smartphone(6, "Smartphone 1", 10_000, "manufacturer 1");
    Product product7 = new Smartphone(7, "Smartphone 2", 20_000, "manufacturer 2");
    Product product8 = new Smartphone(8, "Smartphone 3", 30_000, "manufacturer 3");
    Product product9 = new Smartphone(9, "Smartphone 4", 40_000, "manufacturer 4");
    Product product10 = new Smartphone(10, "Smartphone 5", 50_000, "manufacturer 5");

    ProductRepository product = new ProductRepository();
    ProductManager manager = new ProductManager(product);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);
        manager.add(product10);
    }

    @Test
    public void shouldSave() {

        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        Product[] actual = product.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveWithException() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            manager.add(product10);

        });
    }
}
