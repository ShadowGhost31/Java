import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;

public class Task5 {
    public static void main(String[] args) {

        LocalDateTime labStart = LocalDateTime.of(2024, Month.DECEMBER, 12, 10, 0, 0);


        System.out.println("День тижня: " + labStart.getDayOfWeek());
        System.out.println("День у році: " + labStart.getDayOfYear());
        System.out.println("Місяць: " + labStart.getMonth());
        System.out.println("Рік: " + labStart.getYear());
        System.out.println("Години: " + labStart.getHour());
        System.out.println("Хвилини: " + labStart.getMinute());
        System.out.println("Секунди: " + labStart.getSecond());


        boolean isLeapYear = Year.of(labStart.getYear()).isLeap();
        System.out.println("Рік високосний: " + isLeapYear);


        LocalDateTime now = LocalDateTime.now();


        System.out.println("Поточний час після початку лабораторної?: " + now.isAfter(labStart));
        System.out.println("Поточний час перед початком лабораторної?: " + now.isBefore(labStart));


        LocalDateTime modifiedLabStart = labStart.plusDays(2).plusHours(3);
        System.out.println("Модифікована дата та час: " + modifiedLabStart);
    }
}