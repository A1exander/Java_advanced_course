package nio.example.nio_filesystem.nio_for_stream.reading.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileChannel fChan = null;
        long fileSize;
        MappedByteBuffer mBuf;

        try {
            fin = new FileInputStream("test1.txt");
            fChan = fin.getChannel();
            fileSize = fChan.size();
            mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);

            for(int i = 0; i < fileSize; i++){
                System.out.print((char)mBuf.get());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(fChan != null) fChan.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(fin != null) fin.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
