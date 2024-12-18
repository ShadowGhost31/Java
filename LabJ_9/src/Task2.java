import java.lang.reflect.*;

public class Task2 {
    public static void main(String[] args) {
        try {
            // Отримання об'єкта Class трьома способами
            Class<Employee> clazz1 = Employee.class;
            Class<?> clazz2 = Class.forName("Employee");
            Employee employeeInstance = new Employee();
            Class<?> clazz3 = employeeInstance.getClass();

            System.out.println("Об'єкти Class отримані успішно.");


            System.out.println("\nПоля класу:");
            Field[] fields = clazz1.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Поле: " + field.getName() + ", тип: " + field.getType());
            }

            System.out.println("\nМетоди класу:");
            Method[] methods = clazz1.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Метод: " + method.getName());


                Parameter[] parameters = method.getParameters();
                if (parameters.length > 0) {
                    System.out.print("  Параметри: ");
                    for (Parameter parameter : parameters) {
                        System.out.print(parameter.getType().getName() + " " + parameter.getName() + ", ");
                    }
                    System.out.println();
                }


                System.out.println("  Повертає: " + method.getReturnType().getName());
            }

            System.out.println("\nКонструктори класу:");
            Constructor<?>[] constructors = clazz1.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Конструктор: " + constructor.getName());


                Parameter[] parameters = constructor.getParameters();
                if (parameters.length > 0) {
                    System.out.print("  Параметри: ");
                    for (Parameter parameter : parameters) {
                        System.out.print(parameter.getType().getName() + " " + parameter.getName() + ", ");
                    }
                    System.out.println();
                }
            }


            System.out.println("\nСтворення екземпляра класу через рефлексію:");
            Constructor<Employee> constructor = clazz1.getDeclaredConstructor(String.class, int.class, String.class);
            Employee employee = constructor.newInstance("John Doe", 30, "Developer");
            employee.displayInfo();


            System.out.println("\nВиклик приватного методу через рефлексію:");
            Method privateSetName = clazz1.getDeclaredMethod("setName", String.class);
            privateSetName.setAccessible(true);
            privateSetName.invoke(employee, "Jane Doe");
            employee.displayInfo();


            System.out.println("\nДоступ до приватного поля:");
            Field privateNameField = clazz1.getDeclaredField("name");
            privateNameField.setAccessible(true);
            privateNameField.set(employee, "Alice Johnson");
            System.out.println("Нове значення поля name: " + privateNameField.get(employee));
            employee.displayInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}