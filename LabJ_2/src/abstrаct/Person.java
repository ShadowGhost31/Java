package abstrаct;

import enums.Gender;
import enums.Location;
import interfaces.Human;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Person implements Human {
    protected String firstname;
    protected String lastname;
    protected int age;
    protected Location location;
    protected Gender gender;

    private static AtomicInteger counter = new AtomicInteger();

    {
        this.firstname = "Unknown";
        this.lastname = "Unknown";
        this.age = 0;
        this.location = Location.KIEV;
        this.gender = Gender.MALE;
        counter.incrementAndGet();
    }

    public Person() {}

    public Person(String firstname, String lastname, int age, Gender gender, Location location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    public abstract void getOccupation();

    public String getFullInfo() {
        return firstname + " " + lastname + ", Age: " + age + ", Gender: " + gender + ", Location: " + location;
    }

    public static void showCounter() {
        System.out.println("Total persons created: " + counter.get());
    }

    @Override
    public void sayFullName() {
        System.out.println("Full Name: " + firstname + " " + lastname);
    }

    @Override
    public void sayAge() {
        System.out.println("Age: " + age);
    }

    @Override
    public void sayLocation() {
        System.out.println("Location: " + location);
    }

    @Override
    public void sayGender() {
        System.out.println("Gender: " + gender);
    }
}
