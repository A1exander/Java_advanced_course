package nio.example.nio_filesystem.directory_conent;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        String dirname = "test";
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
               if(Files.isWritable(entry))
                   return  true;
               else
                   return false;
            }
        };

        try(DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname), how)){
            System.out.println("directory: " + dirname);
            for(Path entry: dirstrm){
                BasicFileAttributes attr = Files.readAttributes(entry, BasicFileAttributes.class);
                if(attr.isDirectory()){
                    System.out.print("<DIR> ");
                }else{
                    System.out.print("      ");
                }
                System.out.println(entry.getName(1));
            }
        }catch (InvalidPathException e){
            System.out.println("path error: " + e);
        }catch (NotDirectoryException e){
            System.out.println(dirname + " is not directory: " + e);
        }catch (IOException e){
            System.out.println("I/O error: " + e);
        }
    }
}
