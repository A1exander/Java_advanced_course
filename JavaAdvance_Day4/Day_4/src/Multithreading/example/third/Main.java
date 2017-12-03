package Multithreading.example.third;

/**
 * Created by USER on 30.11.2017.
 */

class NewThread implements Runnable{
    private String name;
    private Thread t;
    private long sleepTime;

    NewThread(String name, long sleepTime){
        this.name = name;
        this.sleepTime = sleepTime;
        t = new Thread(this, name);
        t.start();
    }
    @Override
    public void run() {
        System.out.println("Thread " + name + " has been started: " + t.isAlive());
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            try {
                t.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " + name + " will be destroy: ");
    }

    public Thread getThread(){
        return t;
    }
}
public class Main {
    public static void main(String[] args) {
        try {
            NewThread t1 = new NewThread("First", 500);
//            t1.getThread().join();
            NewThread t2 = new NewThread("Second", 450);
            t2.getThread().join();
            NewThread t3 = new NewThread("Third", 650);
            t3.getThread().join();

            System.out.println("First isAlive?: " + t1.getThread().isAlive());
            System.out.println("Second isAlive?: " + t2.getThread().isAlive());
            System.out.println("Third isAlive?: " + t3.getThread().isAlive());

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
