package classes;

import abstrаct.Person;
import enums.Gender;
import enums.Location;

public class Student extends Person {
    private String course;
    private String speciality;
    private String university;

    public Student(String firstname, String lastname, int age, Gender gender, Location location, String course, String speciality, String university) {
        super(firstname, lastname, age, gender, location);
        this.course = course;
        this.speciality = speciality;
        this.university = university;
    }

    @Override
    public void getOccupation() {
        System.out.println("I am a student.");
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
