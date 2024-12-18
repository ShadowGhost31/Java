import java.util.function.Consumer;

public class Task2b {
    public static void main(String[] args) {
        // Лямбда-вираз для виведення повідомлення про початок пари
        Consumer<String> startMessage = s -> System.out.println("Пара почалася о 8:30");

        Consumer<String> endMessage = s -> System.out.println("Пара закінчилася о 9:50");

        // Використання andThen для об'єднання
        Consumer<String> fullSchedule = startMessage.andThen(endMessage);


        fullSchedule.accept("Пара");
    }
}