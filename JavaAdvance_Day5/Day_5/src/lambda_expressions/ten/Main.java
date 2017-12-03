package lambda_expressions.ten;

/**
 * Created by USER on 01.12.2017.
 */
interface MyFunc{
    TestClass func(int n);
}

class TestClass{
    private int value;

    TestClass(int n){
        this.value = n;
    }
    TestClass(){
        value = 0;
    }

    int getValue(){
        return  value;
    }
}

public class Main {
    public static void main(String[] args) {
        MyFunc myConstruct = TestClass::new;
        Thread t = new Thread(()->{
            for(int i = 0 ; i < 5; i++){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        TestClass tc = myConstruct.func(150);
        System.out.println("Value of TestClass: " + tc.getValue());
    }
}
