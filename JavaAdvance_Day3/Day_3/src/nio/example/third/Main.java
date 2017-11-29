package nio.example.third;

import java.io.IOException;
import java.nio.ByteBuffer;
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
                                        StandardOpenOption.WRITE, StandardOpenOption.CREATE)){

            ByteBuffer mBuf = ByteBuffer.allocate(26);
            for(int i = 0; i < 26; i++){
                mBuf.put((byte)('A' + i));
            }
            mBuf.rewind();
            fChan.write(mBuf);
        }catch (IOException e){
            System.out.println("IO error");
        }
    }
}
