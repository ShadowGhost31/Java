import java.lang.annotation.Annotation;

public class Task3 {
    public static void main(String[] args) {
        try {

            Class<?> annotatedClass = AnnotatedClass.class;


            if (annotatedClass.isAnnotationPresent(InfoAnnotation.class)) {

                InfoAnnotation annotation = annotatedClass.getAnnotation(InfoAnnotation.class);


                System.out.println("Автор: " + annotation.author());
                System.out.println("Версія: " + annotation.version());
                System.out.println("Призначення: " + annotation.purpose());
            }


            AnnotatedClass instance = (AnnotatedClass) annotatedClass.getDeclaredConstructor().newInstance();
            instance.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}