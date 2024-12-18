import java.util.Random;
import java.util.concurrent.*;

public class Task6 {


    private static int sumOfDigits(int number) {
        int sum = 0;
        number = Math.abs(number);
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int[] array = new int[1_000_000];
        Random random = new Random();


        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20001) - 10000; // Випадкове число між -10000 та 10000
        }

        // Однопотокова обробка
        long singleThreadStart = System.currentTimeMillis();
        long singleThreadSum = singleThreadSum(array);
        long singleThreadEnd = System.currentTimeMillis();

        System.out.println("Однопотокова сума цифр масиву: " + singleThreadSum);
        System.out.println("Час виконання (однопотоково): " + (singleThreadEnd - singleThreadStart) + " мс");

        // Багатопотокова обробка
        long multiThreadStart = System.currentTimeMillis();
        long multiThreadSum = multiThreadSum(array);
        long multiThreadEnd = System.currentTimeMillis();

        System.out.println("Багатопотокова сума цифр масиву: " + multiThreadSum);
        System.out.println("Час виконання (багатопотоково): " + (multiThreadEnd - multiThreadStart) + " мс");
    }

    // Однопоточне обчислення суми цифр у масиві
    private static long singleThreadSum(int[] array) {
        long sum = 0;
        for (int number : array) {
            sum += sumOfDigits(number);
        }
        return sum;
    }

    // Багатопоточне обчислення суми цифр у масиві
    private static long multiThreadSum(int[] array) throws InterruptedException, ExecutionException {
        final int threadsCount = 5; // 5 потоків
        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
        int chunkSize = array.length / threadsCount; // Кількість елементів для кожного потоку
        Future<Long>[] tasks = new Future[threadsCount];


        for (int i = 0; i < threadsCount; i++) {
            final int start = i * chunkSize; // Початкова позиція
            final int end = (i == threadsCount - 1) ? array.length : (start + chunkSize); // Кінцева позиція


            tasks[i] = executor.submit(() -> {
                long partialSum = 0;
                for (int j = start; j < end; j++) {
                    partialSum += sumOfDigits(array[j]);
                }
                return partialSum;
            });
        }


        long totalSum = 0;
        for (Future<Long> task : tasks) {
            totalSum += task.get();
        }

        executor.shutdown();
        return totalSum;
    }
}