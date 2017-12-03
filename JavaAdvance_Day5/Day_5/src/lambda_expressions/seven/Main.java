package lambda_expressions.seven;

/**
 * Created by USER on 01.12.2017.
 */
interface MyStringFunc{
    String func(String s);
}

class MyStringOps{
    static String strReverse(String str){
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

class MyStringOps2{
     String strUp(String str){
       return str.toUpperCase();
    }
}

public class Main {
    static String stringOp(MyStringFunc sf, String s){
        return sf.func(s);
    }

    public static void main(String[] args) {
        MyStringOps2 upCase = new MyStringOps2();
        String inStr = "Мама мыла раму";
        String outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println(outStr);
        outStr = stringOp(upCase::strUp, inStr);
        System.out.println(outStr);
    }
}
