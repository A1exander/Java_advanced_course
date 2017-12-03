package Collections.HashSet;

import java.util.HashSet;

/**
 * Created by USER on 30.11.2017.
 */

class CustomObject{
    int a;

    CustomObject(int a){
        this.a = a;
    }

    @Override
    public int hashCode(){
        return a;
    }

    @Override
    public boolean equals(Object o){
        return ((CustomObject)o).a == this.a;
    }

}
public class Main {
    public static void main(String[] args) {
        HashSet<Integer>names = new HashSet<>();
        names.add(1);
        names.add(2);
        names.add(3);
        names.add(4);
        names.add(5);
        names.add(2);

        System.out.println(names.toString());
        HashSet<CustomObject>objects = new HashSet<>();
        objects.add(new CustomObject(1));
        objects.add(new CustomObject(2));
        objects.add(new CustomObject(3));
        objects.add(new CustomObject(4));
        objects.add(new CustomObject(1));

        for(CustomObject obj : objects){
            System.out.print(obj.a + ", ");
        }

    }
}
