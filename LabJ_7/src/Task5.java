import java.util.Scanner;

class SharedData {

    private String data = null;
    private boolean dataReady = false;


    public synchronized void write(String input) {

        while (dataReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Потік Reader перервано.");
            }
        }

        this.data = input;
        this.dataReady = true;

        notify();
    }


    public synchronized String read() {

        while (!dataReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Потік Printer перервано.");
            }
        }

        String result = this.data;
        this.dataReady = false;

        notify();
        return result;
    }
}

class Reader implements Runnable {
    private SharedData sharedData;
    private Scanner scanner;

    public Reader(SharedData sharedData) {
        this.sharedData = sharedData;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("Введіть рядок (або 'exit' для виходу): ");

            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {

                sharedData.write("exit");
                break;
            }

            sharedData.write(input);

            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Потік Reader перервано.");
                break;
            }
        }
        System.out.println("Reader завершив роботу.");
    }
}

class Printer implements Runnable {
    private SharedData sharedData;

    public Printer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {

            String data = sharedData.read();
            if ("exit".equalsIgnoreCase(data)) {

                break;
            }

            System.out.println("Отримано рядок: " + data);
        }
        System.out.println("Printer завершив роботу.");
    }
}

public class Task5 {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();


        Thread readerThread = new Thread(new Reader(sharedData), "Reader");
        Thread printerThread = new Thread(new Printer(sharedData), "Printer");


        readerThread.start();
        printerThread.start();

        try {

            readerThread.join();
            printerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано.");
        }

        System.out.println("Програма завершена!");
    }
}