import entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Angela", 3);
        Customer customer2 = new Customer("Kevin", 4);
        Customer customer3 = new Customer("Jim", 2);
        Customer customer4 = new Customer("Dwight", 1);
        Customer customer5 = new Customer("Mike", 2);
        Customer customer6 = new Customer("Pam", 2);

        ArrayList<Customer> AllCustomers = new ArrayList<>();
        Collections.addAll(AllCustomers, customer1, customer2, customer3, customer4, customer5, customer6);

        Product product1 = new Product("Harry Potter", ProductCategory.BOOKS, 13.50);
        Product product2 = new Product("Sword", ProductCategory.BOYS, 20.00);
        Product product3 = new Product("Barbie", ProductCategory.GIRLS, 42.90);
        Product product4 = new Product("Action Man", ProductCategory.BOYS, 35.20);
        Product product5 = new Product("Sleepy Bear", ProductCategory.BABY, 11.00);
        Product product6 = new Product("Easy-Bake Oven", ProductCategory.GIRLS, 120.00);
        Product product7 = new Product("The Perfect Book", ProductCategory.BOOKS, 190.00);
        Product product8 = new Product("The October List", ProductCategory.BOOKS, 33.90);

        ArrayList<Product> allProducts = new ArrayList<>();
        Collections.addAll(allProducts, product1, product2, product3, product4, product5, product6, product7, product8);

        Order order1 = new Order(
                OrderStatus.PROCESSING,
                LocalDate.of(2024, 10, 15),
                LocalDate.of(2024, 10, 21),
                List.of(product1, product3, product6),
                customer1
        );

        Order order2 = new Order(
                OrderStatus.NEW,
                LocalDate.of(2021, 3, 23),
                LocalDate.of(2021, 4, 2),
                List.of(product7, product4, product5),
                customer2
        );

        Order order3 = new Order(
                OrderStatus.NEW,
                LocalDate.of(2021, 2, 11),
                LocalDate.of(2021, 2, 20),
                List.of(product1, product2, product8),
                customer3
        );

        ArrayList<Order> allOrders = new ArrayList<>();
        Collections.addAll(allOrders, order1, order2, order3);

        //ES1:
        List<Product> booksProducts = allProducts.stream().filter(product -> product.getCategory() == ProductCategory.BOOKS && product.getPrice() < 100).toList();
        System.out.println(booksProducts);

        //ES2:
        List<Order> babyCategoryOrders = allOrders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory() == ProductCategory.BABY)).toList();
        System.out.println(babyCategoryOrders);

        //ES3:
        List<Product> boysProductsWithDiscount = allProducts.stream()
                .filter(product -> product.getCategory() == ProductCategory.BOYS).map(product -> {
                    product.setPrice(product.getPrice() * 0.90);
                    return product;
                })
                .toList();
        System.out.println(boysProductsWithDiscount);


        //ES4:
        List<Order> filteredOrdersByRangeOfDate = allOrders.stream()
                .filter(order -> order.getCustomer().getTier() == 2 && order.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) && order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
                .toList();

        List<Product> customersTier2Products = new ArrayList<>();

        for (Order order : filteredOrdersByRangeOfDate) {
            customersTier2Products.addAll(order.getProducts());
        }

    }

}
