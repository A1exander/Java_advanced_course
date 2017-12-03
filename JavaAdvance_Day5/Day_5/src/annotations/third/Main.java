package annotations.third;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by USER on 01.12.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Id{
    int id() default 0;
}
@Retention(RetentionPolicy.RUNTIME)
@interface Desc{
    String desc() default "unknown";
}

@Id(id=1)
@Desc(desc = "MainClass")

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker{}
public class Main {


    @Id(id=2)
    @Desc()
    @MyMarker
    public static void myMethod(){
        Main main = new Main();

        Annotation annos[] = main.getClass().getAnnotations();
        System.out.println("Annotations for Main");
        for(Annotation a: annos){
            System.out.println(a);
        }
        System.out.println();
        try {
            Method m = main.getClass().getMethod("myMethod");
            annos = m.getAnnotations();
            System.out.println("Annotations for myMethod:");
            for(Annotation a: annos){
                System.out.println(a);
            }

            m = main.getClass().getMethod("myMethod");
            if(m.isAnnotationPresent(MyMarker.class)){
                System.out.println("метод myMethod() помечен маркером");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}
