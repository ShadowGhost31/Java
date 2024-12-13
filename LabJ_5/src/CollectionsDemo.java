import java.util.*;
// TASK 6
public class CollectionsDemo {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6));


        System.out.println("Початковий список: " + numbers);


        Collections.sort(numbers);
        System.out.println("Після сортування (Collections.sort): " + numbers);


        int index = Collections.binarySearch(numbers, 4);
        System.out.println("Позиція числа '4' після сортування: " + index);


        Collections.reverse(numbers);
        System.out.println("Після реверсу (Collections.reverse): " + numbers);


        Collections.shuffle(numbers);
        System.out.println("Після перемішування (Collections.shuffle): " + numbers);


        Collections.fill(numbers, 0);
        System.out.println("Після заповнення (Collections.fill): " + numbers);


        numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6));


        System.out.println("Максимум (Collections.max): " + Collections.max(numbers));
        System.out.println("Мінімум (Collections.min): " + Collections.min(numbers));


        List<Integer> copy = new ArrayList<>(Collections.nCopies(numbers.size(), 0));
        Collections.copy(copy, numbers);
        System.out.println("Список-копія (Collections.copy): " + copy);


        Collections.rotate(numbers, 3);
        System.out.println("Після обертання (Collections.rotate): " + numbers);


        Collection<Integer> checkedCollection = Collections.checkedCollection(new ArrayList<>(numbers), Integer.class);

        System.out.println("Типобезпечна колекція (Collections.checkedCollection): " + checkedCollection);


        numbers.add(3);
        int frequency = Collections.frequency(numbers, 3);
        System.out.println("Частота елемента '3' (Collections.frequency): " + frequency);
    }
}