package Multithreading.example.second;

/**
 * Created by USER on 30.11.2017.
 */
public class ThreadExample extends Thread {

    ThreadExample(String name) {
        setName(name);
//        start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.getName() + ": " + i);
            try {
                this.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
