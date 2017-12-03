package lambda_expressions.second;

/**
 * Created by USER on 01.12.2017.
 */
interface NumericFunc{
    int func(int n);
}
interface StringFunc{
    String stringFunc(String n);
}
public class Main {
    public static void main(String[] args) {
        NumericFunc numFunc;
        StringFunc strFunc;
        //вычисление факториала числа
        numFunc = (n)->{
          int result = 1;
          for(int i = 1; i <= n; i++){
              result = i * result;
          }
          return result;
        };

        System.out.println("Факториал 3 = " + numFunc.func(3));
        System.out.println("Факториал 5 = " + numFunc.func(5));

        strFunc = (str)->{
          String result = "";
          for(int i = str.length() - 1; i >= 0; i--){
              result += str.charAt(i);
          }
          return result;
        };
        String stroke = "Мама мыла раму";
        System.out.println("input stroke: " + stroke);
        System.out.println("output stroke after reverse: " + strFunc.stringFunc(stroke));
    }
}
