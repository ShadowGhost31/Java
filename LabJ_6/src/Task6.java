import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Task6 {
    public static void main(String[] args) {

        String directoryPath = "LabJ_6/directory_for_files";
        String zipFilePath = "LabJ_6/archive.zip";


        createZipArchive(directoryPath, zipFilePath);


        listFilesInZip(zipFilePath);
    }


    public static void createZipArchive(String directoryPath, String zipFilePath) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Директорія не знайдена або не є папкою.");
            return;
        }

        try (
                FileOutputStream fos = new FileOutputStream(zipFilePath);
                ZipOutputStream zos = new ZipOutputStream(fos)
        ) {

            addToZip(directory, directory.getName(), zos);

            System.out.println("Усі файли та папки успішно додано до архіву: " + zipFilePath);
        } catch (IOException e) {
            System.err.println("Помилка під час створення архіву: " + e.getMessage());
        }
    }
    private static void addToZip(File file, String zipPath, ZipOutputStream zos) throws IOException {
        if (file.isDirectory()) {

            if (!zipPath.endsWith("/")) {
                zipPath += "/";
            }
            zos.putNextEntry(new ZipEntry(zipPath));
            zos.closeEntry();


            File[] files = file.listFiles();
            if (files != null) {
                for (File child : files) {
                    addToZip(child, zipPath + child.getName(), zos);
                }
            }
        } else {

            try (FileInputStream fis = new FileInputStream(file)) {
                ZipEntry zipEntry = new ZipEntry(zipPath);
                zos.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }

                zos.closeEntry();
                System.out.println("Додано до архіву: " + zipPath);
            }
        }
    }


    public static void listFilesInZip(String zipFilePath) {
        try (
                FileInputStream fis = new FileInputStream(zipFilePath);
                ZipInputStream zis = new ZipInputStream(fis)
        ) {
            System.out.println("Список файлів та папок у архіві " + zipFilePath + ":");
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                if (zipEntry.isDirectory()) {
                    System.out.println("Папка: " + zipEntry.getName());
                } else {
                    System.out.println("Файл: " + zipEntry.getName());
                }
                zis.closeEntry();
            }
        } catch (IOException e) {
            System.err.println("Помилка під час читання архіву: " + e.getMessage());
        }
    }
}