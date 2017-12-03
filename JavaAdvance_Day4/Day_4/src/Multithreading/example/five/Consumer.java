package Multithreading.example.five;

/**
 * Created by USER on 30.11.2017.
 */
public class Consumer extends Thread {
    Info info;

    Consumer(Info info){
        this.info = info;
        setName("Потребитель");
        start();
    }

    public void run(){
        while(true){
            info.get();
        }
    }
}
