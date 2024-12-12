public class Task1 {

    public static void main(String[] args) {
        String input = "I learn Java!!!";


        printLastChar(input);
        System.out.println("Закінчується '!!!': " + endsWithSubstring(input, "!!!"));
        System.out.println("Починається з 'I learn ': " + startsWithSubstring(input, "I learn "));
        System.out.println("Містить 'Java': " + containsSubstring(input, "Java"));
        System.out.println("Індекс 'Java': " + getSubstringPosition(input, "Java"));
        System.out.println("Заміна 'a' на 'o': " + replaceCharacter(input, 'a', 'o'));
        System.out.println("Верхній регістр: " + toUpperCase(input));
        System.out.println("Нижній регістр: " + toLowerCase(input));
        System.out.println("Вирізано підрядок 'Java': " + cutSubstring(input, "Java"));
    }


    public static void printLastChar(String str) {
        if (str != null && !str.isEmpty()) {
            System.out.println("Останній символ: " + str.charAt(str.length() - 1));
        } else {
            System.out.println("Рядок порожній або null.");
        }
    }


    public static boolean endsWithSubstring(String str, String substring) {
        return str != null && str.endsWith(substring);
    }


    public static boolean startsWithSubstring(String str, String substring) {
        return str != null && str.startsWith(substring);
    }


    public static boolean containsSubstring(String str, String substring) {
        return str != null && str.contains(substring);
    }


    public static int getSubstringPosition(String str, String substring) {
        return str != null ? str.indexOf(substring) : -1;
    }


    public static String replaceCharacter(String str, char oldChar, char newChar) {
        return str != null ? str.replace(oldChar, newChar) : null;
    }

    public static String toUpperCase(String str) {
        return str != null ? str.toUpperCase() : null;
    }


    public static String toLowerCase(String str) {
        return str != null ? str.toLowerCase() : null;
    }


    public static String cutSubstring(String str, String substring) {
        if (str != null && str.contains(substring)) {
            return str.replace(substring, "");
        }
        return str;
    }
}