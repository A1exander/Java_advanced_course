package Multithreading.example.second;

/**
 * Created by USER on 30.11.2017.
 */
public class ThreadFromRunnable implements Runnable {

    Thread t;

    ThreadFromRunnable(String name){
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println(t.getName()+ ": " + i);
            try {
               t.sleep(450);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
