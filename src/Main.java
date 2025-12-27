import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // 1. Sample Products
        List<Product> products = Arrays.asList(
                new Product(1L, "Laptop", "Electronics", 1200.0),
                new Product(2L, "Smartphone", "Electronics", 800.0),
                new Product(3L, "Headphones", "Electronics", 150.0),
                new Product(4L, "Coffee Maker", "Kitchen", 100.0),
                new Product(5L, "Air Fryer", "Kitchen", 200.0),
                new Product(6L, "Desk Chair", "Furniture", 300.0)
        );

        // 2. Sample Customers
        List<Customer> customers = Arrays.asList(
                new Customer(101L, "Alice", "New York", "Gold"),
                new Customer(102L, "Bob", "San Francisco", "Silver"),
                new Customer(103L, "Charlie", "New York", "Bronze")
        );

        // 3. Sample Orders
        List<Order> orders = Arrays.asList(
                // Alice (NYC) bought a Laptop and Headphones
                new Order(5001L, Arrays.asList(products.get(0), products.get(2)), "SHIPPED", 101L),

                // Bob (SF) bought a Smartphone
                new Order(5002L, Arrays.asList(products.get(1)), "SHIPPED", 102L),

                // Charlie (NYC) bought an Air Fryer
                new Order(5003L, Arrays.asList(products.get(4)), "PENDING", 103L),

                // Alice (NYC) bought a Desk Chair
                new Order(5004L, Collections.singletonList(products.get(5)), "SHIPPED", 101L)
        );


        //Given a List<Product>, write a Java 8 stream expression to return a List<String> containing the names of all products that belong to the "Electronics" category and have a price greater than $500.

        System.out.println(Optional.of(products).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(product -> product.getCategory().equalsIgnoreCase("Electronics")
                        && product.getPrice()>500)
                .map(Product::getName)
                .filter(Objects::nonNull)
                .toList());

        //You have a List<Order>. Each order contains a list of products. Write a stream to get a count of unique products across all orders that have a status of "SHIPPED".

        System.out.println(Optional.of(orders).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(order -> order.getStatus().equalsIgnoreCase("SHIPPED"))
                .flatMap(order -> order.getProducts().stream())
                .filter(Objects::nonNull)
                .distinct()
                .count());

        //Given a List<Product>, group the products by their category and calculate the average price for each category.
        // The result should be a Map<String, Double>.

        Map<String, Double> collect = products.stream()
                .filter(product -> product!=null && product.getCategory()!=null)
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        System.out.println(collect);

        //You have a List<Order> and a List<Customer>.
        // Find the total revenue (sum of all product prices) generated specifically by customers who live in "New York".

        List<Long> custIds = customers.stream()
                .filter(Objects::nonNull)
                .filter(customer -> customer.getCity().equalsIgnoreCase("New York"))
                .map(Customer::getId).toList();


        System.out.println(orders.stream().filter(order -> custIds.contains(order.getCustomerId()))
                .flatMap(order -> order.getProducts().stream())
                .filter(Objects::nonNull)
                .mapToDouble(Product::getPrice)
                .sum());

        //From a List<Product>, create a Map<String, Product> where the key is the category and the value is the most expensive
        // product in that category. If two products have the same price, you can pick either.
        Map<String, Product> collect1 = products.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)),Optional::get)));

        System.out.println(collect1);
    }
    }
