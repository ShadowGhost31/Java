import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Task4 {
    public static void main(String[] args) {
        String filePath = "LabJ_6/copy_directory/copy.txt";


        try {
            RandomAccessFile file = new RandomAccessFile(new File(filePath), "rw");
            addTextAtPosition(file, "11   Шапка           Аксесуари          400,25 ₴       \n", 560);
            addTextAtPosition(file, "4.5  Жилет           Чоловічий одяг     750,50 ₴       \n", 255);

            file.close();
            System.out.println("Текст успішно дописано у файл.");
        } catch (IOException e) {
            System.err.println("Помилка під час роботи з файлом: " + e.getMessage());
        }
    }

    public static void addTextAtPosition(RandomAccessFile file, String text, long position) throws IOException {

        file.seek(position);
        byte[] remainingBytes = new byte[(int) (file.length() - position)];
        file.readFully(remainingBytes);
        file.seek(position);
        file.write(text.getBytes());
        file.write(remainingBytes);
    }
}