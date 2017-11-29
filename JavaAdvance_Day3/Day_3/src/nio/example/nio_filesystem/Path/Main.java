package nio.example.nio_filesystem.Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Path filepath = Paths.get("test/test.txt");
        System.out.println("file_name: " + filepath.getName(1));
        System.out.println("file_path: " + filepath);
        System.out.println("abs_file_path: " + filepath.toAbsolutePath());
        System.out.println("parent_catalog: " + filepath.getParent());

        if(Files.exists(filepath)){
            System.out.println("file is exist");
        }else{
            System.out.println("file is not exist");
        }

        if(Files.isHidden(filepath)){
            System.out.println("file is hidden");
        }else{
            System.out.println("file is not hidden");
        }
        System.out.println("Acces for write? " + Files.isWritable(filepath));
        System.out.println("Acces for read? " + Files.isReadable(filepath));

        BasicFileAttributes attr = Files.readAttributes(filepath, BasicFileAttributes.class);
        if(attr.isDirectory()){
            System.out.println("file is dir");
        }else{
            System.out.println("file is not dir");
        }
        if(attr.isRegularFile()){
            System.out.println("file is regular");
        }else{
            System.out.println("file is not regular");
        }
        if(attr.isSymbolicLink()){
            System.out.println("file is symbolic link");
        }else{
            System.out.println("file is not symbolic link");
        }

        System.out.println("last modified time: " + attr.lastModifiedTime());
        System.out.println("last acces time: " + attr.lastAccessTime());
        System.out.println("file size: " + attr.size() + " bytes");
    }
}
