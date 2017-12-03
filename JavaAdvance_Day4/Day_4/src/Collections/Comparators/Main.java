package Collections.Comparators;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by USER on 30.11.2017.
 */

class MyComp implements Comparator<String>{

    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
}
public class Main {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>((a, b) -> b.compareTo(a));
        ts.add("C");
        ts.add("B");
        ts.add("A");
        ts.add("H");
        ts.add("R");

        for(String el: ts){
            System.out.print(el + ", ");
        }
        System.out.println();

        new CompExample();
    }
}
