import java.util.NavigableSet;
import java.util.TreeSet;

public class ProductSetDemo {
    public static void main(String[] args) {
// TASK 4
        NavigableSet<Product> productSet = new TreeSet<>((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));


        productSet.add(new Product("Laptop", 1200.99, 5));
        productSet.add(new Product("Smartphone", 899.49, 10));
        productSet.add(new Product("Tablet", 499.99, 8));
        productSet.add(new Product("Smart Watch", 199.99, 12));
        productSet.add(new Product("Headphones", 99.99, 15));


        System.out.println("Вміст множини:");
        for (Product product : productSet) {
            System.out.println(product);
        }


        System.out.println("Перший продукт (first): " + productSet.first());
        System.out.println("Останній продукт (last): " + productSet.last());


        System.out.println("Продукти дешевші за $900 (headSet):");
        for (Product product : productSet.headSet(new Product("", 900, 0))) {
            System.out.println(product);
        }

        System.out.println("Продукти дорожчі або рівно $500 (tailSet):");
        for (Product product : productSet.tailSet(new Product("", 500, 0))) {
            System.out.println(product);
        }

        System.out.println("Продукти між $200 і $1000 (subSet):");
        for (Product product : productSet.subSet(new Product("", 200, 0), new Product("", 1000, 0))) {
            System.out.println(product);
        }


        System.out.println("Продукт з ціною ≥ $500 (ceiling): " + productSet.ceiling(new Product("", 500, 0)));
        System.out.println("Продукт з ціною ≤ $500 (floor): " + productSet.floor(new Product("", 500, 0)));
        System.out.println("Продукт з ціною більше $200 (higher): " + productSet.higher(new Product("", 200, 0)));
        System.out.println("Продукт з ціною менше $500 (lower): " + productSet.lower(new Product("", 500, 0)));


        System.out.println("Видаляємо найдешевший продукт (pollFirst): " + productSet.pollFirst());
        System.out.println("Видаляємо найдорожчий продукт (pollLast): " + productSet.pollLast());


        System.out.println("Продукти у зворотному порядку (descendingSet):");
        for (Product product : productSet.descendingSet()) {
            System.out.println(product);
        }


        System.out.println("Остаточний розмір множини: " + productSet.size());
    }
}