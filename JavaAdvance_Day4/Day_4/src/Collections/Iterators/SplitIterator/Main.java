package Collections.Iterators.SplitIterator;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Double>values = new ArrayList<>();
        values.add(1.0);
        values.add(2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0);
        System.out.println("values content: ");
        Spliterator<Double> spltIter = values.spliterator();
        while (spltIter.tryAdvance((n)-> System.out.print(n + ", ")));
        System.out.println();

        spltIter = values.spliterator();
        ArrayList<Double>pows = new ArrayList<>();
        while (spltIter.tryAdvance((n)->pows.add(Math.pow(n, 2))));

        System.out.println("sqr content: ");
        spltIter = pows.spliterator();
        spltIter.forEachRemaining((n)-> System.out.print(n + ", "));
    }
}
