import java.io.*;

public class Task3 {

    public static void main(String[] args) {

        String sourceTextFile = "LabJ_6/copy_directory/receipt.txt";
        String destinationTextFile = "LabJ_6/copy_directory/copy.txt";

        String sourceImageFile = "LabJ_6/copy_directory/source.jpg";
        String destinationImageFile = "LabJ_6/copy_directory/copy.jpg";


        copyTextFile(sourceTextFile, destinationTextFile);


        copyBinaryFile(sourceImageFile, destinationImageFile);
    }


    public static void copyTextFile(String sourcePath, String destinationPath) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Текстовий файл успішно скопійовано.");
        } catch (IOException e) {
            System.err.println("Помилка під час копіювання текстового файлу: " + e.getMessage());
        }
    }


    public static void copyBinaryFile(String sourcePath, String destinationPath) {
        try (
                FileInputStream inputStream = new FileInputStream(sourcePath);
                FileOutputStream outputStream = new FileOutputStream(destinationPath)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Файл зображення успішно скопійовано.");
        } catch (IOException e) {
            System.err.println("Помилка під час копіювання зображення: " + e.getMessage());
        }
    }
}