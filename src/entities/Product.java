package entities;

import java.util.Random;

public class Product {
    private final Long id;
    private String name;
    private ProductCategory category;
    private double price;

    public Product(String name, ProductCategory category, double price) {
        Random rndm = new Random();
        this.id = rndm.nextLong(1, 100000);
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
