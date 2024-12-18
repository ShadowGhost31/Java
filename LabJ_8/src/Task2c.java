import java.util.function.Supplier;

public class Task2c {
    public static void main(String[] args) {
        // Лямбда-вираз для виводу рядка у верхньому регістрі
        Supplier<String> toUpperCase = () -> "Hello, this is a sentence.".toUpperCase();


        System.out.println(toUpperCase.get());
    }
}