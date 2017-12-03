package annotations.second;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by USER on 01.12.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@interface FirstAnno {
    String str();
    int val();
}

public class Main {
    @FirstAnno(str="пример аннотации", val=1)
    public  static void doSomthing(String a, String b){
        Main ob = new Main();

        Class<?> cl = ob.getClass();
        try {
            Method m = cl.getMethod("doSomthing", String.class, String.class);
            FirstAnno anno = m.getAnnotation(FirstAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        doSomthing("5","5");
    }
}
