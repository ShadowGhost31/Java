import java.util.Scanner;

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Логін має невірний формат.");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Пароль має невірний формат.");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

public class Task1 {
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {

            if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Логін повинен містити лише латинські літери, цифри або підкреслення і бути меншим за 20 символів.");
            }


            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Пароль повинен містити лише латинські літери, цифри або підкреслення і бути меншим за 20 символів.");
            }


            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль і підтвердження пароля не співпадають.");
            }


            return true;
        } catch (WrongLoginException | WrongPasswordException e) {

            System.err.println("Помилка: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;


        while (!isValid) {

            System.out.print("Введіть логін: ");
            String login = scanner.nextLine();


            System.out.print("Введіть пароль: ");
            String password = scanner.nextLine();


            System.out.print("Підтвердіть пароль: ");
            String confirmPassword = scanner.nextLine();


            isValid = checkCredentials(login, password, confirmPassword);


            if (isValid) {
                System.out.println("Логін та пароль є дійсними.");
            } else {
                System.out.println("Спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}