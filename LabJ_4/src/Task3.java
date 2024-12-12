import java.util.Formatter;

public class Task3 {

    public static void main(String[] args) {
        // Дата і час покупки
        String purchaseDateTime = "28.03.2019 13:25:12";

        // Створюємо список товарів
        Object[][] items = {
                {1, "Джинси", "Жіночий одяг", 1500.78},
                {2, "Спідниця", "Жіночий одяг", 1000.56},
                {3, "Краватка", "Чоловічий одяг", 500.78},
                {4, "Сорочка", "Чоловічий одяг", 1200.34},
                {5, "Футболка", "Чоловічий одяг", 600.25},
                {6, "Штани", "Жіночий одяг", 1800.20},
                {7, "Сукня", "Жіночий одяг", 2500.00},
                {8, "Шарф", "Аксесуари", 300.50},
                {9, "Ремінь", "Аксесуари", 450.75},
                {10, "Пальто", "Жіночий одяг", 3500.99},
        };

        // Вивід чека у форматованому вигляді
        printReceipt(purchaseDateTime, items);
    }

    public static void printReceipt(String purchaseDateTime, Object[][] items) {
        Formatter formatter = new Formatter();
        double total = 0; // Для зберігання загальної суми

        // Заголовок
        formatter.format("Дата та час покупки: %s%n", purchaseDateTime);
        formatter.format("===========================================%n");
        formatter.format("%-4s %-12s %-16s %-10s%n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("===========================================%n");

        // Вивід інформації про товари
        for (Object[] item : items) {
            int number = (int) item[0];
            String name = (String) item[1];
            String category = (String) item[2];
            double price = (double) item[3];

            formatter.format("%-4d %-12s %-16s %-10.2f ₴%n", number, name, category, price);
            total += price; // Додаємо до загальної суми
        }

        // Підсумок
        formatter.format("===========================================%n");
        formatter.format("Разом: %.2f ₴%n", total);

        // Виводимо чек у консоль
        System.out.println(formatter);
    }
}