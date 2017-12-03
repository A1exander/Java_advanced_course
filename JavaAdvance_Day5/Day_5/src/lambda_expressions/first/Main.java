package lambda_expressions.first;

/**
 * Created by USER on 01.12.2017.
 */
interface MyNumber{
    double getValue();
}
interface NumTest{
    boolean test(int n);
}
interface NumTest2{
    boolean test(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        MyNumber myNum;
        NumTest numTest;
        NumTest2 numTest2;
        myNum = ()-> 100.523;
        System.out.println("Фиксированное значение: " + myNum.getValue());

        myNum = ()-> Math.random() * 10;
        System.out.println("Случайные значение: " + myNum.getValue());
        System.out.println("Случайные значение: " + myNum.getValue());

        myNum = ()-> Double.parseDouble("123.09");
        System.out.println(myNum.getValue());

        numTest = (n)-> (n % 2) == 0;
        System.out.println("Проверка числа 10, четное/нечетное: " + numTest.test(10));
        System.out.println("Проверка числа 11, четное/нечетное: " + numTest.test(11));

        numTest = (n)-> n >=0;
        System.out.println("Число 5 > 0 = " + numTest.test(5));
        System.out.println("Число -5 > 0 = " + numTest.test(-5));

        numTest2 = (a, b)->(a % b) == 0;
        System.out.println("Число 2 - множнитель 10: " + numTest2.test(10, 2));
        System.out.println("Число 3 - множнитель 10: " + numTest2.test(10, 3));
    }
}
