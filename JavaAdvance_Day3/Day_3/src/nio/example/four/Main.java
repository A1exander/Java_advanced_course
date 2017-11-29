package nio.example.four;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        try(FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test1.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.READ)){
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 27, 53);
            for(int i = 27; i < 53; i++){
                mBuf.put((byte)('a' + i));
            }
            System.out.println("Запись произошла успешно");
        }catch (IOException e){

        }
    }
}
