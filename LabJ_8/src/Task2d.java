import java.util.function.Function;

public class Task2d {
    public static void main(String[] args) {
        // Лямбда-вираз для обчислення добутку чисел з рядка
        Function<String, Integer> calculateProduct = s -> {
            String[] numbers = s.split(" ");
            int product = 1;
            for (String num : numbers) {
                product *= Integer.parseInt(num);
            }
            return product;
        };


        String input = "2 3 4";
        System.out.println("Product of numbers: " + calculateProduct.apply(input)); // 24
    }
}