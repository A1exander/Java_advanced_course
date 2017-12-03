package Collections.Iterators.DefaultIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        String el;
        al.add("C");
        al.add("B");
        al.add("A");
        al.add("H");
        al.add("R");
        al.add("W");

        Iterator<String> itr = al.iterator();
        while(itr.hasNext()){
            el = itr.next();
            System.out.print(el + ", ");
        }
        System.out.println();
        ListIterator<String>litr = al.listIterator();
        while (litr.hasNext()){
           el = litr.next();
           litr.set(el + " + ");
        }
        System.out.println("ArrayList after change ");
        itr = al.iterator();
        while (itr.hasNext()){
            el = itr.next();
            System.out.print(el);
        }

        System.out.println();
        while (litr.hasPrevious()){
            el = litr.previous();
            System.out.print(el + ", ");
        }
    }
}
