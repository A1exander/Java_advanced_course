package lambda_expressions.six;

/**
 * Created by USER on 01.12.2017.
 */
interface MyFunc{
    int func(int n);
}
public class Main {
    public static void main(String[] args) {
        int a = 5;
        MyFunc varInLamda = (n)->{
            int b = 5;
            //так можно!
            b = a + b;

//            Так делать нельзя!
//            a++;

            return b;
        };
//        a = 10;
    }
}
