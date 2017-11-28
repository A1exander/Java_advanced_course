package example.Object.cloning;

import javax.swing.*;

/**
 * Created by USER on 27.11.2017.
 */
public class TestClone implements Cloneable {
    int a;
    double b;

    TestClone cloneTest(){
        try {
            return (TestClone) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Копировать нельзя");
            return this;
        }
    }
}

class TestClone2 implements Cloneable{
    int a;
    double b;

    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Копировать нельзя");
            return this;
        }
    }
}

class CloneDemo{
    public static void main(String[] args) {
        TestClone t1 = new TestClone();
        TestClone t2;
        TestClone2 t2_1 = new TestClone2();
        TestClone2 t2_2;
        JPanel panel;
        t1.a = 100;
        t1.b = 150.12423;
        t2_1.a = 10;
        t2_1.b = 10.23412;

        t2 = t1.cloneTest();
        t2_2 = (TestClone2)t2_1.clone();
        System.out.println("t1: " + t1.a + ", " + t1.b);
        System.out.println("t2: " + t2.a + ", " + t2.b);

        System.out.println("t2_1: " + t2_1.a + ", " + t2_1.b);
        System.out.println("t2_2: " + t2_2.a + ", " + t2_2.b);
    }
}
