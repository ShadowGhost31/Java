public class Employee {

    private String name;
    private int age;
    public String position;


    public Employee() {
        this.name = "Default Name";
        this.age = 0;
        this.position = "Unknown";
    }

    public Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }


    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Position: " + position);
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getName() {
        return this.name;
    }
}