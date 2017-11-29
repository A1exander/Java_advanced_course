package nio.example.nio_filesystem.nio_for_stream.reading.first;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        FileChannel fChan = null;
        ByteBuffer mBuf;
        int count;
        FileInputStream fin = null;

        try {
            fin = new FileInputStream("test1.txt");
            fChan = fin.getChannel();
            mBuf = ByteBuffer.allocate(128);

            do{
                count = fChan.read(mBuf);
                if(count != -1){
                    mBuf.rewind();

                    for(int i = 0; i < count; i++){
                        System.out.print((char)mBuf.get());
                    }
                }
            }while (count != -1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fChan != null){
                try {
                    fChan.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fin != null){
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
