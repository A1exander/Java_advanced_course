package Reflection.example.second;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by USER on 30.11.2017.
 */

class TestClass extends JFrame implements ActionListener{
    protected String example = "blabla";

    public String getExample(){
        return example;
    }

    private String blabla(){
        return "blabla";
    }

    public String strokePlusStroke(String s1, String s2){
        return  s1 + s2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
public class Main {

    public static void main(String[] args) {
        new Main();
    }

    Main(){
        try {
            Class testClass = Class.forName("Reflection.example.second.TestClass");
            TestClass tc = (TestClass)testClass.newInstance();
            reflectFields(testClass, tc);
            reflectMethods(testClass, tc);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    void reflectFields(Class example, TestClass tc){
        try {
            Field f = example.getDeclaredField("example");
            f.setAccessible(true);
            String test = (String)f.get(tc);
            System.out.println("test: " + test);
            System.out.println("example of TestClass: " + tc.getExample());
            f.set(tc, "test");
            System.out.println("example of TestClass: " + tc.getExample());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    void reflectMethods(Class example, TestClass tc){
        try {
            Method method = example.getMethod("getExample");
            String getExample = (String)method.invoke(tc);
            System.out.println("return statement of getExample(): " + getExample);

            Class[] paramTypes = new Class[]{String.class, String.class};
            Method refl_strokePlusStroke = example.getMethod("strokePlusStroke", paramTypes);


            String result = (String)refl_strokePlusStroke.invoke(tc, "a", "b");
            System.out.println("Result: " + result);

            Field[] fields = example.getDeclaredFields();
            Method[] methods = example.getDeclaredMethods();

            Package p = example.getPackage();
            System.out.println("package of example: " + p.getName());

            System.out.println("superclass of TestClass: " + example.getSuperclass());
            Class[]interfaces = example.getInterfaces();
            System.out.println("interfaces:");
            for(int i = 0; i < interfaces.length;i++){
                System.out.println(interfaces[i].getSimpleName());
            }

            for(Field f: fields){
                System.out.println("field: " + f.getModifiers() +  " " + f.getType() + " " + f.getName());
            }
            for(Method m: methods){
                System.out.println("method: " + m.getModifiers() +  " " + m.getReturnType() + " " + m.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
