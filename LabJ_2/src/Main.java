import classes.Teacher;
import classes.Employee;
import classes.Car;
import classes.Student;
import enums.Gender;
import enums.Location;
import abstrаct.Person;

public class Main {
    public static void main(String[] args) {
        Car teacherCar = new Car("Toyota");
        Teacher teacher = new Teacher("John", "Doe", 40, Gender.MALE, Location.KIEV, "Math", "KPI", teacherCar);

        Car employeeCar = new Car("BMW");
        Employee employee = new Employee("Jane", "Smith", 30, Gender.FEMALE, Location.ZHYTOMYR, "TechCorp", "Manager", employeeCar);

        Student student = new Student("Alice", "Johnson", 20, Gender.FEMALE, Location.RIVNE, "CS", "Software Engineering", "NULP");

        teacher.sayFullName();
        teacher.getOccupation();

        employee.sayFullName();
        employee.getOccupation();

        student.sayFullName();
        student.getOccupation();

        teacherCar.getEngine().startEngine();
        System.out.println("Is engine working? " + teacherCar.getEngine().isEngineWorks());
        teacherCar.getEngine().stopEngine();

        System.out.println("Instanceof checks:");
        System.out.println(teacher instanceof Person);
        System.out.println(employee instanceof Person);
        System.out.println(student instanceof Person);

        Person.showCounter();

        double[] numbers = {10, 20, 30, 40};

        System.out.println("Додавання: " + Operation.addition(numbers));
        System.out.println("Віднімання: " + Operation.subtraction(numbers));
        System.out.println("Множення: " + Operation.multiplication(numbers));
        System.out.println("Ділення: " + Operation.division(numbers));
        System.out.println("Середнє: " + Operation.average(numbers));
        System.out.println("Максимум: " + Operation.maximum(numbers));
        System.out.println("Мінімум: " + Operation.minimum(numbers));

        System.out.println("\nLocations:");
        for (Location location : Location.values()) {
            System.out.println(location);
        }
    }
}