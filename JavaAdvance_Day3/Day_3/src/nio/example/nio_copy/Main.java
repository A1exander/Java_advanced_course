package nio.example.nio_copy;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        Path source = Paths.get("test.txt");
        Path target = Paths.get("test1.txt");
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("файл успешно скопирован");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
