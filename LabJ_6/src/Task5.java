import java.io.File;
import java.io.IOException;

public class Task5 {
    public static void main(String[] args) {

        String parentDirectoryPath = "LabJ_6/directory_for_files";


        File innerDirectory = new File(parentDirectoryPath, "inner_directory");
        if (innerDirectory.mkdir()) {
            System.out.println("Папку створено: " + innerDirectory.getAbsolutePath());
        } else {
            System.out.println("Не вдалося створити папку.");
        }


        System.out.println("Абсолютний шлях: " + innerDirectory.getAbsolutePath());


        System.out.println("Батьківська директорія: " + innerDirectory.getParent());


        File file1 = new File(innerDirectory, "file1.txt");
        File file2 = new File(innerDirectory, "file2.txt");
        try {
            if (file1.createNewFile()) {
                System.out.println("Файл створено: " + file1.getAbsolutePath());
            }
            if (file2.createNewFile()) {
                System.out.println("Файл створено: " + file2.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Помилка під час створення файлів: " + e.getMessage());
        }


        if (file1.delete()) {
            System.out.println("Файл видалено: " + file1.getName());
        } else {
            System.out.println("Не вдалося видалити файл: " + file1.getName());
        }


        File renamedDirectory = new File(parentDirectoryPath, "renamed_inner_directory");
        if (innerDirectory.renameTo(renamedDirectory)) {
            System.out.println("Директорію перейменовано: " + renamedDirectory.getAbsolutePath());
        } else {
            System.out.println("Не вдалося перейменувати директорію.");
        }


        File mainDirectory = new File(parentDirectoryPath);
        if (mainDirectory.exists() && mainDirectory.isDirectory()) {
            File[] files = mainDirectory.listFiles();
            if (files != null) {
                System.out.println("Список файлів і папок в " + mainDirectory.getAbsolutePath() + ":");
                for (File file : files) {
                    String type = file.isDirectory() ? "Папка" : "Файл";
                    long size = file.isFile() ? file.length() : 0;
                    System.out.println(type + " - " + file.getName() + " - Розмір: " + size + " байтів");
                }
            } else {
                System.out.println("Директорія порожня.");
            }
        } else {
            System.out.println("Директорія не знайдена.");
        }
    }
}