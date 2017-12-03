package Multithreading.example.five;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        Info info = new Info();
        new Producer(info);
        new Consumer(info);
    }
}
