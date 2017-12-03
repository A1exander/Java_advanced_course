package Collections.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> someList = new ArrayList();
        someList.add("dsds");
        someList.add(new String("fdsfd"));

        ArrayList<ArrayList>userTable = new ArrayList();
        ArrayList<Integer>ids = new ArrayList<>();
        ArrayList<String>names = new ArrayList<>();
        ArrayList<String>surnames = new ArrayList<>();

        ids.add(1);
        ids.add(2);
        ids.add(3);

        names.add("Ivan");
        names.add("Petr");
        names.add("Maria");

        surnames.add("Petrov");
        surnames.add("Sidorov");
        surnames.add("Sokolova");

        userTable.add(ids);
        userTable.add(names);
        userTable.add(surnames);

        for(int i = 0; i < userTable.size(); i++){
            for(int j = 0; j < userTable.get(i).size(); j++){
                System.out.print(userTable.get(j).get(i) + " ");
            }
            System.out.println();
        }

        ArrayList<Integer>values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        System.out.println(values.toString());
        values.remove(3);
        System.out.println(values.toString());
        values.add(1, 5);
        System.out.println(values.toString());

        LinkedList<String>ll = new LinkedList<>();
        ll.addFirst("Z");
        ll.addLast("A");
        ll.add("dasds");
        ll.add("dasds");
        ll.add("dasds");
        ll.add("dasds");
        ll.add("dasds");

        String[]storkeFromLL = new String[ll.size()];
        storkeFromLL = ll.toArray(storkeFromLL);

        for(String stroke: storkeFromLL){
            System.out.println(stroke);
        }




    }
}
