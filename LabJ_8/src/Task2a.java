import java.util.function.Predicate;

public class Task2a {
    public static void main(String[] args) {

        Predicate<String> isNumeric = s -> {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };


        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Predicate<String> combinedCheck = isNumeric.and(isNotEmpty);


        String testString1 = "123";
        String testString2 = "abc";
        System.out.println("\"" + testString1 + "\" is numeric: " + combinedCheck.test(testString1)); // true
        System.out.println("\"" + testString2 + "\" is numeric: " + combinedCheck.test(testString2)); // false
    }
}