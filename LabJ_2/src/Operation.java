public class Operation {

    public static double addition(double... numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static double subtraction(double... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("Немає аргументів");
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static double multiplication(double... numbers) {
        double result = 1;
        for (double num : numbers) {
            result *= num;
        }
        return result;
    }

    public static double division(double... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("Немає аргументів");
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) throw new ArithmeticException("Ділення на 0");
            result /= numbers[i];
        }
        return Math.round(result * 10000);
    }

    public static double average(double... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("Немає аргументів");
        return (double) addition(numbers) / numbers.length;
    }

    public static double maximum(double... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("Немає аргументів");
        double max = numbers[0];
        for (double num : numbers) {
            if (num > max) max = num;
        }
        return max;
    }

    public static double minimum(double... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("Немає аргументів");
        double min = numbers[0];
        for (double num : numbers) {
            if (num < min) min = num;
        }
        return min;
    }
}