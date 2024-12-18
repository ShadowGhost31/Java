import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    public static void main(String[] args) {

        String employees = """
                Іванов Іван Іванович, вік: 30, дата народження: 20.05.1992, 
                посада: Менеджер, досвід роботи: 5 років, адреса: Київ, email: ivanov@example.com, телефон: +380501234567.
                
                Петров Петро Петрович, вік: 26, дата народження: 15.10.1996, 
                посада: Розробник, досвід роботи: 3 роки, адреса: Львів, email: petrov@example.com, телефон: +380671112233.
                
                Смирнова Олена Василівна, вік: 40, дата народження: 28.03.1983, 
                посада: HR, досвід роботи: 10 років, адреса: Харків, email: smirnova@example.com, телефон: +380931234567.
                """;

        // 1. Знайти всі номери телефонів
        System.out.println("Номери телефонів:");
        Pattern phonePattern = Pattern.compile("\\+\\d{12}");
        Matcher phoneMatcher = phonePattern.matcher(employees);
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }

        // 2. Знайти всі емайли
        System.out.println("\nЕлектронні адреси:");
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher emailMatcher = emailPattern.matcher(employees);
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }

        // 3. Змінити формати дат народження
        System.out.println("\nТекст із відформатованими датами:");
        String updatedEmployeesDates = employees.replaceAll("(\\d{2})\\.(\\d{2})\\.(\\d{4})", "$3-$2-$1");
        System.out.println(updatedEmployeesDates);

        // 4. Змінити посади кільком співробітникам
        System.out.println("\nТекст із оновленими посадами:");
        String updatedEmployeesPositions = updatedEmployeesDates
                .replaceAll("Менеджер", "Керівник відділу")
                .replaceAll("Розробник", "Старший розробник")
                .replaceAll("HR", "Менеджер з персоналу");
        System.out.println(updatedEmployeesPositions);
    }
}