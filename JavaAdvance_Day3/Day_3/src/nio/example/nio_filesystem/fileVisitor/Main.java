package nio.example.nio_filesystem.fileVisitor;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        String dirname = "D:\\soft\\IntelliJ IDEA 2017.1\\workspace\\JavaAdvance_3\\Day_3";
        System.out.println("Дерево каталогов, начиная с " + dirname + ":\n");
        try {
            Files.walkFileTree(Paths.get(dirname), new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attributes)
                        throws  IOException{
                    System.out.println(path);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
