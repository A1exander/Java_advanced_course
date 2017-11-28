package example.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //System получение времени
        long start, end = 0;
//        start = System.currentTimeMillis();
        start = System.nanoTime();
        System.out.println("Измерение времени перебора от 0 до 100000000L");
        for(long i = 0; i < 100000000L; i++) {
//            end = System.currentTimeMillis();
            end = System.nanoTime();
        }

        System.out.println("Время выполнения: " + (end - start));

        Date currDate = new Date(System.currentTimeMillis());
        System.out.println("Current date: " + currDate);

        //System копирование массивов

        byte[]a = {65,66,67,68,69,70,71,72,73,74};
        byte[]b = {75,75,75,75,75,75,75,75,75,75};
        System.out.println("a[]:" + new String(a));
        System.out.println("b[]: " + new String(b));
        System.arraycopy(a, 0, b,0, a.length);
        System.out.println("a[]:" + new String(a));
        System.out.println("b[]: " + new String(b));
        System.arraycopy(a, 0, a, 1, a.length - 1);
        System.arraycopy(b, 1, b, 0, b.length - 1);
        System.out.println("a[]:" + new String(a));
        System.out.println("b[]: " + new String(b));
        //System ввод\вывод
        try(FileInputStream fis = new FileInputStream("in.txt");
            FileOutputStream fos = new FileOutputStream("out.txt")){
            System.setIn(fis);
            char ch = (char)System.in.read();
            System.out.print(ch + " ");
            System.setOut(new PrintStream(fos));
            System.out.write("Hello from IDEA".getBytes());

            System.setErr(new PrintStream(fos));
            System.err.write("Что-то пошло не так".getBytes());
        }catch (IOException e){
                e.printStackTrace();
        }
    }
}
