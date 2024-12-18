import java.lang.reflect.*;

public class Task2 {
    public static void main(String[] args) {
        try {
            // Отримання об'єкта Class трьома способами
            Class<Employee> clazz1 = Employee.class; // Спосіб 1: Через ім'я класу
            Class<?> clazz2 = Class.forName("Employee"); // Спосіб 2: Через forName
            Employee employeeInstance = new Employee(); // Спосіб 3: Через екземпляр об'єкта
            Class<?> clazz3 = employeeInstance.getClass();

            System.out.println("Об'єкти Class отримані успішно.");

            // Отримання тільки полів, методів та конструкторів, визначених у цьому класі
            System.out.println("\nПоля класу:");
            Field[] fields = clazz1.getDeclaredFields(); // Поля класу (тільки ті, що в цьому класі)
            for (Field field : fields) {
                System.out.println("Поле: " + field.getName() + ", тип: " + field.getType());
            }

            System.out.println("\nМетоди класу:");
            Method[] methods = clazz1.getDeclaredMethods(); // Методи класу
            for (Method method : methods) {
                System.out.println("Метод: " + method.getName());

                // Типи параметрів методу
                Parameter[] parameters = method.getParameters();
                if (parameters.length > 0) {
                    System.out.print("  Параметри: ");
                    for (Parameter parameter : parameters) {
                        System.out.print(parameter.getType().getName() + " " + parameter.getName() + ", ");
                    }
                    System.out.println();
                }

                // Тип значення, що повертається
                System.out.println("  Повертає: " + method.getReturnType().getName());
            }

            System.out.println("\nКонструктори класу:");
            Constructor<?>[] constructors = clazz1.getDeclaredConstructors(); // Конструктори класу
            for (Constructor<?> constructor : constructors) {
                System.out.println("Конструктор: " + constructor.getName());

                // Типи параметрів конструктора
                Parameter[] parameters = constructor.getParameters();
                if (parameters.length > 0) {
                    System.out.print("  Параметри: ");
                    for (Parameter parameter : parameters) {
                        System.out.print(parameter.getType().getName() + " " + parameter.getName() + ", ");
                    }
                    System.out.println();
                }
            }

            // Створення екземпляра класу
            System.out.println("\nСтворення екземпляра класу через рефлексію:");
            Constructor<Employee> constructor = clazz1.getDeclaredConstructor(String.class, int.class, String.class);
            Employee employee = constructor.newInstance("John Doe", 30, "Developer"); // Використовуємо параметризований конструктор
            employee.displayInfo(); // Виклик методу через звичайний спосіб

            // Виклик методу класу через Reflection
            System.out.println("\nВиклик приватного методу через рефлексію:");
            Method privateSetName = clazz1.getDeclaredMethod("setName", String.class);
            privateSetName.setAccessible(true); // Доступ до приватного методу
            privateSetName.invoke(employee, "Jane Doe"); // Виклик методу та встановлення нового ім'я
            employee.displayInfo(); // Перевірка зміни значення

            // Робота з приватним полем
            System.out.println("\nДоступ до приватного поля:");
            Field privateNameField = clazz1.getDeclaredField("name");
            privateNameField.setAccessible(true); // Доступ до приватного поля
            privateNameField.set(employee, "Alice Johnson"); // Зміна значення
            System.out.println("Нове значення поля name: " + privateNameField.get(employee)); // Отримання значення поля
            employee.displayInfo(); // Виведення після зміни значення

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}