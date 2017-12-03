package Collections.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer>al = new ArrayList<>();
        al.add(-1);
        al.add(-5);
        al.add(0);
        al.add(10);

        Comparator<Integer> comp = Collections.reverseOrder();
        Collections.sort(al, comp);
        System.out.println(al.toString());

        Collections.shuffle(al);
        System.out.println(al.toString());
        System.out.println("max of al: " + Collections.max(al));
        System.out.println("min of al: " + Collections.min(al));
    }
}
