import java.lang.annotation.*;

// Оголошення власної анотації
@Retention(RetentionPolicy.RUNTIME) // Утримання (зберігається у Runtime, доступна через Reflection)
@Target(ElementType.TYPE) // Обмеження для застосування (лише до класів/інтерфейсів)
public @interface InfoAnnotation {
    String author() default "Unknown"; // Поле зі значенням за замовчуванням
    String version() default "1.0"; // Поле - версія
    String purpose(); // Поле без значення за замовчуванням (обов'язкове)
}