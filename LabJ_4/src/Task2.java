public class Task2 {

    public static void main(String[] args) {

        // Дано два числа
        int num1 = 4;
        int num2 = 36;

        // Складання рядків
        StringBuilder sb1 = new StringBuilder();
        sb1.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        System.out.println("Рядок 1: " + sb1);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        System.out.println("Рядок 2: " + sb2);

        StringBuilder sb3 = new StringBuilder();
        sb3.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println("Рядок 3: " + sb3);

        // Замінюємо символ "=" на "рівно" методами insert() і deleteCharAt()
        System.out.println("\nЗамінюємо '=' на 'рівно' (методи insert() і deleteCharAt()):");
        replaceEqualWithWord(sb1);
        replaceEqualWithWord(sb2);
        replaceEqualWithWord(sb3);

        // Замінюємо символ "=" на "рівно" методом replace()
        System.out.println("\nЗамінюємо '=' на 'рівно' (метод replace()):");
        StringBuilder sb4 = new StringBuilder("4 / 36 = 0.111");
        sb4.replace(sb4.indexOf("="), sb4.indexOf("=") + 1, "рівно");
        System.out.println("Рядок 4: " + sb4);

        // Змінюємо послідовність розташування символів в рядку на протилежну
        System.out.println("\nРеверс рядків (метод reverse()):");
        System.out.println("Реверс рядка 1: " + sb1.reverse());
        System.out.println("Реверс рядка 2: " + sb2.reverse());
        System.out.println("Реверс рядка 3: " + sb3.reverse());

        // Довжина та capacity рядка
        System.out.println("\nІнформація про довжину та capacity:");
        System.out.println("Довжина sb1: " + sb1.length() + ", Capacity sb1: " + sb1.capacity());
        System.out.println("Довжина sb2: " + sb2.length() + ", Capacity sb2: " + sb2.capacity());
        System.out.println("Довжина sb3: " + sb3.length() + ", Capacity sb3: " + sb3.capacity());
    }

    // Метод для заміни '=' на 'рівно' за допомогою insert() і deleteCharAt()
    private static void replaceEqualWithWord(StringBuilder sb) {
        int equalIndex = sb.indexOf("="); // Знаходимо символ "="
        if (equalIndex != -1) {
            sb.deleteCharAt(equalIndex);          // Видаляємо символ "="
            sb.insert(equalIndex, "рівно");      // Вставляємо слово "рівно"
        }
        System.out.println(sb);
    }
}