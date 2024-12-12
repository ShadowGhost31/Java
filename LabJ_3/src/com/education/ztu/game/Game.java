package com.education.ztu.game;

public class Game {
    public static void main(String[] args) {

        Schoolar schoolar1 = new Schoolar("Рома", 14);
        Schoolar schoolar2 = new Schoolar("Оля", 13);
        Schoolar schoolar3 = new Schoolar("Тарас", 15);
        Schoolar schoolar4 = new Schoolar("Наталя", 14);

        Student student1 = new Student("Андрій", 20);
        Student student2 = new Student("Марія", 19);
        Student student3 = new Student("Олег", 21);
        Student student4 = new Student("Ніна", 20);

        Employee employee1 = new Employee("Юрій", 30);
        Employee employee2 = new Employee("Катя", 28);
        Employee employee3 = new Employee("Михайло", 32);
        Employee employee4 = new Employee("Олена", 29);


        Team<Schoolar> schoolarTeam1 = new Team<>("Команда Школярів 1");
        Team<Schoolar> schoolarTeam2 = new Team<>("Команда Школярів 2");
        Team<Student> studentTeam1 = new Team<>("Команда Студентів 1");
        Team<Student> studentTeam2 = new Team<>("Команда Студентів 2");
        Team<Employee> employeeTeam1 = new Team<>("Команда Працівників 1");
        Team<Employee> employeeTeam2 = new Team<>("Команда Працівників 2");


        schoolarTeam1.addPlayer(schoolar1);
        schoolarTeam1.addPlayer(schoolar2);
        schoolarTeam2.addPlayer(schoolar3);
        schoolarTeam2.addPlayer(schoolar4);

        studentTeam1.addPlayer(student1);
        studentTeam1.addPlayer(student2);
        studentTeam2.addPlayer(student3);
        studentTeam2.addPlayer(student4);

        employeeTeam1.addPlayer(employee1);
        employeeTeam1.addPlayer(employee2);
        employeeTeam2.addPlayer(employee3);
        employeeTeam2.addPlayer(employee4);


        System.out.println("\n--- Гра між командами школярів ---");
        schoolarTeam1.playMatchWith(schoolarTeam2);

        System.out.println("\n--- Гра між командами студентів ---");
        studentTeam1.playMatchWith(studentTeam2);

        System.out.println("\n--- Гра між командами працівників ---");
        employeeTeam1.playMatchWith(employeeTeam2);
    }
}
