
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Я люблю програмувати!!!");
        }
    }
}


public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("Початкове ім'я потоку: " + myThread.getName());
        System.out.println("Початковий пріоритет потоку: " + myThread.getPriority());
        System.out.println("Чи потік живий: " + myThread.isAlive());
        System.out.println("Чи є потік демоном: " + myThread.isDaemon());

        myThread.setName("CustomThread");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Оновлене ім'я потоку: " + myThread.getName());
        System.out.println("Оновлений пріоритет потоку: " + myThread.getPriority());

        System.out.println("Стан потоку (NEW): " + myThread.getState());
        myThread.start();
        Thread.sleep(10);
        System.out.println("Стан потоку (RUNNING): " + myThread.getState());

        myThread.join();
        System.out.println("Стан потоку (TERMINATED): " + myThread.getState());

        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());
    }
}
