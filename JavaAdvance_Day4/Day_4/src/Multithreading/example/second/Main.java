package Multithreading.example.second;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        new ThreadExample("Thread").start();
        new ThreadFromRunnable("Runnable");
        Thread t = Thread.currentThread();
        t.setName("MainThread");
        for(int i = 0; i < 5; i++){
            System.out.println(t.getName() + ": " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
