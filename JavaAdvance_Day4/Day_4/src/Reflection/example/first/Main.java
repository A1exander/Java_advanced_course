package Reflection.example.first;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        InfoBuilder ib = InfoBuilderFactory.getInfoBuilder();
        Information info = ib.buildInformation();
        System.out.println("class_name:" + ib.getClass().getCanonicalName());
    }
}
