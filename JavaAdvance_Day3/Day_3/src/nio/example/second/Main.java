package nio.example.second;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        try(FileChannel fChan = (FileChannel)Files.newByteChannel(Paths.get("test.txt"))){
            long fSize = fChan.size();
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
            for(int i = 0; i < fSize;i++){
                System.out.print((char)mBuf.get());
            }
        }catch (IOException e){

        }
    }
}
