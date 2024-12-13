import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
// TASK 2
public class ProductDemo {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();


        products.add(new Product("Apple", 0.5, 10));
        products.add(new Product("Banana", 0.2, 20));
        products.add(new Product("Orange", 0.8, 15));


        List<Product> moreProducts = new ArrayList<>();
        moreProducts.add(new Product("Mango", 1.5, 8));
        moreProducts.add(new Product("Pineapple", 3.0, 5));
        products.addAll(moreProducts);


        System.out.println("Розмір списку: " + products.size());


        System.out.println("Продукт на індексі 1: " + products.get(1));


        int index = products.indexOf(new Product("Banana", 0.2, 20));
        System.out.println("Індекс 'Banana': " + index);

        products.set(0, new Product("Apple (Updated)", 0.6, 12));
        System.out.println("Після оновлення: " + products.get(0));


        Product removed = products.remove(2);
        System.out.println("Видалено продукт: " + removed);


        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Після сортування за ціною:");
        for (Product product : products) {
            System.out.println(product);
        }


        List<Product> subList = products.subList(1, 3);
        System.out.println("Список субліста:");
        for (Product product : subList) {
            System.out.println(product);
        }


        System.out.println("Перебір за допомогою ітератора:");
        for (Product product : products) {
            System.out.println(product);
        }


        products.clear();
        System.out.println("Список очищено. Порожній?: " + products.isEmpty());
    }
}