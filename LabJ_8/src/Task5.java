import java.util.Optional;
import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {

        Integer[] numbers = {3, 7, 12, 5, 9};


        String result = Arrays.stream(numbers)
                .max(Integer::compareTo)
                .map(String::valueOf)
                .orElse("Числа відсутні");

        System.out.println("Максимальне значення: " + result);


        Integer[] emptyNumbers = {};


        String emptyResult = Arrays.stream(emptyNumbers)
                .max(Integer::compareTo)
                .map(String::valueOf)
                .orElse("Числа відсутні");

        System.out.println("Результат для порожнього масиву: " + emptyResult);
    }
}