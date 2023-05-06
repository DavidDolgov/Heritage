package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryAndManagerTests {

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
    public void shouldRepositorySave() {

        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        Product[] actual = product.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRepositoryRemoveById() {
        product.removeById(product4.getId());
        product.removeById(product5.getId());
        product.removeById(product9.getId());
        product.removeById(product10.getId());

        Product[] expected = {product1, product2, product3, product6, product7, product8};
        Product[] actual = product.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManagerSearchByText1() {
        String text1 = "Book 1";

        Product[] expected1 = {product1};
        Product[] actual1 = manager.searchBy(text1);

        Assertions.assertArrayEquals(expected1, actual1);
    }

    @Test
    public void shouldManagerSearchByText2() {
        String text2 = "Smartphone 1";

        Product[] expected2 = {product6};
        Product[] actual2 = manager.searchBy(text2);

        Assertions.assertArrayEquals(expected2, actual2);
    }

    @Test
    public void shouldManagerSearchByText3() {
        String text3 = "1";

        Product[] expected3 = {product1, product6};
        Product[] actual3 = manager.searchBy(text3);

        Assertions.assertArrayEquals(expected3, actual3);
    }

    @Test
    public void shouldManagerSearchByText4() {
        String text4 = "Book";

        Product[] expected4 = {product1, product2, product3, product4, product5};
        Product[] actual4 = manager.searchBy(text4);

        Assertions.assertArrayEquals(expected4, actual4);
    }

    @Test
    public void shouldManagerSearchByText5() {
        String text5 = "Smartphone";

        Product[] expected5 = {product6, product7, product8, product9, product10};
        Product[] actual5 = manager.searchBy(text5);

        Assertions.assertArrayEquals(expected5, actual5);
    }

    @Test
    public void shouldManagerSearchByText6() {
        String text6 = "";

        Product[] expected6 = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        Product[] actual6 = manager.searchBy(text6);

        Assertions.assertArrayEquals(expected6, actual6);
    }

    @Test
    public void shouldManagerSearchByText7() {
        String text7 = " ";

        Product[] expected7 = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        Product[] actual7 = manager.searchBy(text7);

        Assertions.assertArrayEquals(expected7, actual7);
    }

    @Test
    public void shouldNotManagerSearchByText1() {
        String text1 = "Book Smartphone";


        Product[] expected1 = {};
        Product[] actual1 = manager.searchBy(text1);

        Assertions.assertArrayEquals(expected1, actual1);
    }

    @Test
    public void shouldNotManagerSearchByText2() {
        String text2 = "Book 1 Book 2";

        Product[] expected2 = {};
        Product[] actual2 = manager.searchBy(text2);

        Assertions.assertArrayEquals(expected2, actual2);
    }
}
