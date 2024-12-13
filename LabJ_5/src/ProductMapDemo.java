import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// TASK 5
public class ProductMapDemo {
    public static void main(String[] args) {

        Map<String, Product> productMap = new HashMap<>();


        productMap.put("Laptop", new Product("Laptop", 1200.99, 5));
        productMap.put("Smartphone", new Product("Smartphone", 899.49, 10));
        productMap.put("Tablet", new Product("Tablet", 499.99, 8));


        productMap.putIfAbsent("Headphones", new Product("Headphones", 99.99, 15));
        productMap.putIfAbsent("Tablet", new Product("Tablet", 450.00, 6)); // не додасться, оскільки ключ існує


        System.out.println("Розмір Map: " + productMap.size());


        System.out.println("Отримати продукт 'Smartphone': " + productMap.get("Smartphone"));


        System.out.println("Map містить ключ 'Tablet'?: " + productMap.containsKey("Tablet"));
        System.out.println("Map містить значення для Headphones?: " + productMap.containsValue(new Product("Headphones", 99.99, 15)));


        Product removedProduct = productMap.remove("Laptop");
        System.out.println("Видалено продукт: " + removedProduct);


        Map<String, Product> additionalProducts = new HashMap<>();
        additionalProducts.put("Smart Watch", new Product("Smart Watch", 199.99, 12));
        additionalProducts.put("Camera", new Product("Camera", 299.99, 7));
        productMap.putAll(additionalProducts);


        Set<String> keys = productMap.keySet();
        System.out.println("Ключі в Map:");
        for (String key : keys) {
            System.out.println(key);
        }


        System.out.println("Значення в Map:");
        for (Product product : productMap.values()) {
            System.out.println(product);
        }


        System.out.println("Робота з entrySet:");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());


            if (entry.getKey().equals("Smartphone")) {
                entry.setValue(new Product("Smartphone (Updated)", 850.00, 12));
            }
        }


        System.out.println("Map після змін:");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        productMap.clear();
        System.out.println("Map очищено. Порожній?: " + productMap.isEmpty());
    }
}