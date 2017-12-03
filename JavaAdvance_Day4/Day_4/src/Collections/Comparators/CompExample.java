package Collections.Comparators;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by USER on 30.11.2017.
 */

class MyNamesComp implements Comparator<String>{

    @Override
    public int compare(String a, String b) {
        int i, j;
        i = a.lastIndexOf(' ');
        j = b.lastIndexOf(' ');
       return a.substring(i).compareToIgnoreCase(b.substring(j));
    }
}
class MyCompThenByFirst implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}
public class CompExample {

    CompExample(){

        MyNamesComp comp_1 = new MyNamesComp();
        Comparator<String> compLastThenFirst = comp_1.thenComparing(new MyCompThenByFirst());
        TreeMap<String, Integer>tm = new TreeMap<>(compLastThenFirst);
        tm.put("Иванов Иван", new Integer(1));
        tm.put("Александров Петр", new Integer(5));
        tm.put("Борисов Владимир", new Integer(10));
        tm.put("Галкин Максим", new Integer(55));
        tm.put("Борисов Дмитрий", new Integer(-10));

        Set<Map.Entry<String, Integer>> set = tm.entrySet();
        for(Map.Entry<String, Integer>user : set){
            System.out.println(user.getKey() +": " + user.getValue());
        }
    }
}
