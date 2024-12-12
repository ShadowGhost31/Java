import java.text.NumberFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Task4 {

    public static void main(String[] args) {

        Locale localeUA = new Locale("uk", "UA");
        Locale localeEN = new Locale("en", "US");
        Locale localeES = new Locale("es", "ES");


        Locale currentLocale = localeUA; // localeUA, localeEN, localeES
        printReceipt(currentLocale);
    }

    public static void printReceipt(Locale locale) {
        ResourceBundle bundle;


        try {
            bundle = ResourceBundle.getBundle("data", locale);
        } catch (MissingResourceException e) {
            System.err.println("Missing resource bundle for locale: " + locale + ". Using default settings.");
            locale = Locale.getDefault(); // Устанавливаем локаль по умолчанию
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


        System.out.println(bundle.getString("title"));
        System.out.println(bundle.getString("dateAndTime") + ": 28.03.2019 13:25:12");
        System.out.println("===============================================");
        System.out.printf("%-4s %-15s %-18s %-15s%n",
                bundle.getString("number"), bundle.getString("item"),
                bundle.getString("category"), bundle.getString("price"));
        System.out.println("===============================================");


        double total = 0;
        for (Object[] item : items) {
            int number = (int) item[0];
            String name = (String) item[1];
            String category = (String) item[2];
            double price = (double) item[3];

            System.out.printf("%-4d %-15s %-18s %-15s%n",
                    number,
                    name,
                    category,
                    currencyFormatter.format(price));
            total += price;
        }


        System.out.println("===============================================");
        System.out.printf("%-37s %-15s%n", bundle.getString("total"), currencyFormatter.format(total));
    }
}