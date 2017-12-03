package Multithreading.example.four;

/**
 * Created by USER on 30.11.2017.
 */
class CallMe {
    void call(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String message;
    Thread t;
    CallMe target;

    Caller(CallMe target, String message) {
        this.target = target;
        this.message = message;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(message);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller c1 = new Caller(target, "Добро пожаловать");

        Caller c2 = new Caller(target, "в синхронизацию");
        Caller c3 = new Caller(target, "на Java");
    }
}
