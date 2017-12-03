package Multithreading.example.first;

public class Main {
    public static void main(String[] args) {
       Thread mainThread = Thread.currentThread();
        System.out.println("Current main thread: " + mainThread);
        mainThread.setName("Primary thread");
        System.out.println("Current main thread after change: " + mainThread);

        for(int i = 0; i < 5; i++){
            System.out.print(i + ", ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Main thread has been interrupted");
            }
        }
    }
}
