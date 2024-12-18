import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface InfoAnnotation {
    String author() default "Unknown";
    String version() default "1.0";
    String purpose();
}