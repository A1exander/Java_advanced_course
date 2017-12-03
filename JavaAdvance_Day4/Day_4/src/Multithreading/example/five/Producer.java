package Multithreading.example.five;

/**
 * Created by USER on 30.11.2017.
 */
public class Producer extends Thread {
    Info info;

    Producer(Info info){
        this.info = info;
        setName("Поставщик");
        start();
    }

    public void run(){
        int i = 0;
        while(true){
            info.put(i++);
            try {
                this.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
