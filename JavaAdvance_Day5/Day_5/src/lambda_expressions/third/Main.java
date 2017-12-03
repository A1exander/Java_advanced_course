package lambda_expressions.third;

/**
 * Created by USER on 01.12.2017.
 */
interface SomeFunc<T>{
    T func(T t);
}
public class Main {
    public static void main(String[] args) {
        SomeFunc<String> reverse = (str)->{
            String result = "";
            for(int i = str.length() - 1; i >= 0; i--){
                result += str.charAt(i);
            }
            return result;
        };

        SomeFunc<Integer> factorial = (n)->{
            int result = 1;
            for(int i = 1; i <= n; i++){
                result = i * result;
            }
            return result;
        };

        System.out.println("Факториал 10 " + factorial.func(10));
        System.out.println("Перевод строки " + reverse.func("Мама мыла раму"));
    }
}
