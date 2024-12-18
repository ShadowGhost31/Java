public class Task1 {
    public static void main(String[] args) {

        Printable printable = () -> System.out.println("Hello from Printable!");

        printable.print();
    }
}