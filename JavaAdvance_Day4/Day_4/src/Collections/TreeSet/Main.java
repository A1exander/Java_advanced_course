package Collections.TreeSet;

import java.util.TreeSet;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        TreeSet<String>strokes = new TreeSet<>();
        strokes.add("Abc");
        strokes.add("abc");
        strokes.add("fsdfsd");
        strokes.add("BLABLA");
        strokes.add("123213");
        strokes.add("fdsfdFDFDS");
        System.out.println(strokes.toString());
    }
}
