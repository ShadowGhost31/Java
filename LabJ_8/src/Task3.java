import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String brand;
    private double price;
    private int count;

    public Product(String name, String brand, double price, int count) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', brand='" + brand + "', price=" + price + ", count=" + count + "}";
    }
}

public class Task3 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Dell", 1200, 10),
                new Product("Phone", "Apple", 900, 15),
                new Product("TV", "Samsung", 800, 5),
                new Product("Headphones", "Sony", 200, 20),
                new Product("Watch", "Apple", 500, 8)
        );

        // 1. Отримати всі бренди та вивести їх у консоль
        System.out.println("Бренди:");
        products.stream()
                .map(Product::getBrand)
                .distinct()
                .forEach(System.out::println);

        // 2. Отримати 2 товари, ціна яких менше тисячі
        System.out.println("\nТовари з ціною менше 1000:");
        products.stream()
                .filter(product -> product.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        // 3. Отримати суму всіх видів товарів, що є на складі
        int totalProductCount = products.stream()
                .map(Product::getCount)
                .reduce(0, Integer::sum);
        System.out.println("\nСума всіх видів товарів на складі: " + totalProductCount);

        // 4. Згрупувати товари по бренду
        System.out.println("\nТовари, згруповані по бренду:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand));
        groupedByBrand.forEach((brand, productList) -> {
            System.out.println("Бренд: " + brand);
            productList.forEach(System.out::println);
        });

        // 5. Відсортувати товари за зростанням ціни та повернути як масив
        System.out.println("\nТовари, відсортовані за зростанням ціни:");
        Product[] sortedProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toArray(Product[]::new);
        for (Product p : sortedProducts) {
            System.out.println(p);
        }
        Optional<Product> cheapestProduct = products.stream()
                .min(Comparator.comparingDouble(Product::getPrice));
        cheapestProduct.ifPresent(product ->
                System.out.println("\nНайдешевший товар: " + product));
    }
}