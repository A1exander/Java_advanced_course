package nio.example.first;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        try(SeekableByteChannel fChan = Files.newByteChannel(Paths.get("test.txt"))){
            int count = 0;
            ByteBuffer mBuf = ByteBuffer.allocate(128);
            while(count != -1) {
                count = fChan.read(mBuf);
                if(count != -1){
                    mBuf.rewind();

                    for(int i = 0;i < count; i++){
                        System.out.print((char)mBuf.get());
                    }
                }
            }
        }catch (InvalidPathException e){
            System.out.println("Ошибка в в пути: " + e);
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
