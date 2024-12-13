import java.util.ArrayDeque;
import java.util.Deque;

public class ProductQueueDemo {
    public static void main(String[] args) {
// TASK 3
        Deque<Product> queue = new ArrayDeque<>();


        queue.offerLast(new Product("Laptop", 1200.99, 5));
        queue.offerLast(new Product("Smartphone", 899.49, 10));
        queue.push(new Product("Headphones", 99.99, 15));


        System.out.println("Перший елемент в черзі (getFirst): " + queue.getFirst());
        System.out.println("Останній елемент в черзі (peekLast): " + queue.peekLast());


        System.out.println("Видаляємо перший елемент (pop): " + queue.pop());
        System.out.println("Видаляємо останній елемент (removeLast): " + queue.removeLast());


        System.out.println("Залишились у черзі:");
        for (Product product : queue) {
            System.out.println(product);
        }


        queue.offerLast(new Product("Tablet", 499.99, 8));
        queue.offerLast(new Product("Smart Watch", 199.99, 12));


        System.out.println("Видаляємо останній елемент (pollLast): " + queue.pollLast());


        System.out.println("Розмір черги: " + queue.size());


        System.out.println("Черга порожня?: " + queue.isEmpty());


        queue.clear();
        System.out.println("Чергу очищено. Порожня?: " + queue.isEmpty());
    }
}