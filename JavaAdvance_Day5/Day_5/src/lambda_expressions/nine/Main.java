package lambda_expressions.nine;

/**
 * Created by USER on 01.12.2017.
 */
interface MyFunc<T>{
    int func(T[] values, T v);
}
class MyArrayOps{
    static <T> int countMatching(T[]vals, T v){
        int count = 0;
        for(int i = 0; i < vals.length;i++){
            if(vals[i] == v)count++;
        }
        return  count;
    }
}
public class Main {

    static <T> int myOp(MyFunc<T> f, T[]vals, T v){
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 4, 4, 6, 10};
        String[] strokes = {"Один", "Два", "Три", "Четыре", "Три", "Три"};
        int count;
        count = myOp(MyArrayOps::<Integer>countMatching, values, 4);
        System.out.println("Count of 4 of values[]: " + count);
        count = myOp(MyArrayOps::<String>countMatching, strokes, "Три");
        System.out.println("Count 'Три' of strokes[]: " + count);
    }
}
