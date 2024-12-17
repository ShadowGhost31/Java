import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Task2 {

    public static void main(String[] args) {
        Locale localeUA = new Locale("uk", "UA");
        Locale localeEN = new Locale("en", "US");
        Locale localeES = new Locale("es", "ES");

        Locale currentLocale = localeUA; // localeUA, localeEN, localeES

        // Задаємо шлях до папки directory_for_files, що знаходиться в LabJ_6
        String projectDir = "LabJ_6";
        String directoryPath = projectDir + File.separator + "directory_for_files";
        String fileName = "receipt.txt";

        // Генеруємо звіт
        String receiptContent = generateReceipt(currentLocale);

        // Формуємо повний шлях до файлу
        String filePath = directoryPath + File.separator + fileName;

        // Записуємо звіт у файл
        writeToFile(filePath, receiptContent, directoryPath);

        // Читаємо звіт із файлу
        readFromFile(filePath);
    }

    public static String generateReceipt(Locale locale) {
        ResourceBundle bundle;

        try {
            bundle = ResourceBundle.getBundle("data", locale);
        } catch (MissingResourceException e) {
            System.err.println("Missing resource bundle for locale: " + locale + ". Using default settings.");
            locale = Locale.getDefault();
            bundle = ResourceBundle.getBundle("data", locale);
        }

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
                {10, "Пальто", "Жіночий одяг", 3500.99}
        };

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append(bundle.getString("title")).append("\n");
        receiptBuilder.append(bundle.getString("dateAndTime") + ": 28.03.2019 13:25:12").append("\n");
        receiptBuilder.append("===============================================\n");
        receiptBuilder.append(String.format("%-4s %-15s %-18s %-15s%n",
                bundle.getString("number"), bundle.getString("item"),
                bundle.getString("category"), bundle.getString("price")));
        receiptBuilder.append("===============================================\n");

        double total = 0;
        for (Object[] item : items) {
            int number = (int) item[0];
            String name = (String) item[1];
            String category = (String) item[2];
            double price = (double) item[3];
            receiptBuilder.append(String.format("%-4d %-15s %-18s %-15s%n",
                    number,
                    name,
                    category,
                    currencyFormatter.format(price)));
            total += price;
        }

        receiptBuilder.append("===============================================\n");
        receiptBuilder.append(String.format("%-37s %-15s%n", bundle.getString("total"), currencyFormatter.format(total)));

        return receiptBuilder.toString();
    }

    public static void writeToFile(String filePath, String content, String directoryPath) {
        FileWriter writer = null;
        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Директорію створено: " + directoryPath);
                } else {
                    System.err.println("Не вдалося створити директорію: " + directoryPath);
                    return;
                }
            }

            writer = new FileWriter(filePath);
            writer.write(content);
            System.out.println("Звіт успішно записано до файлу: " + filePath);
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Помилка при закритті файлу: " + e.getMessage());
                }
            }
        }
    }

    public static void readFromFile(String filePath) {
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
            int character;
            System.out.println("Звіт з файлу:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.err.println("Помилка при читанні з файлу: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Помилка при закритті файлу: " + e.getMessage());
                }
            }
        }
    }
}