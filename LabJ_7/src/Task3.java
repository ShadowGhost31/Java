class ArithmeticProgressionRunnable implements Runnable {

    private static int result = 1;

    private synchronized void printProgression() {
        System.out.print(result + " ");
        result += 1;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (ArithmeticProgressionRunnable.class) {
                printProgression();
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Потік " + Thread.currentThread().getName() + " перервано.");
                return;
            }
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ArithmeticProgressionRunnable(), "Thread-1");
        Thread thread2 = new Thread(new ArithmeticProgressionRunnable(), "Thread-2");
        Thread thread3 = new Thread(new ArithmeticProgressionRunnable(), "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано.");
        }

        System.out.println("\nВсі потоки завершено!");
    }
}