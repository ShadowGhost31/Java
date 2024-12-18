import java.lang.annotation.Annotation;

public class Task3 {
    public static void main(String[] args) {
        try {
            // Отримання об'єкта Class для AnnotatedClass
            Class<?> annotatedClass = AnnotatedClass.class;

            // Перевірка наявності анотації @InfoAnnotation
            if (annotatedClass.isAnnotationPresent(InfoAnnotation.class)) {
                // Отримання анотації
                InfoAnnotation annotation = annotatedClass.getAnnotation(InfoAnnotation.class);

                // Виведення даних анотації
                System.out.println("Автор: " + annotation.author());
                System.out.println("Версія: " + annotation.version());
                System.out.println("Призначення: " + annotation.purpose());
            }

            // Створення об'єкта AnnotatedClass та виклик його методу
            AnnotatedClass instance = (AnnotatedClass) annotatedClass.getDeclaredConstructor().newInstance();
            instance.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}