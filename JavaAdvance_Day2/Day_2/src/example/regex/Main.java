package example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
       //abc+
        /*
        * + - совпадение 1 или > 1 раза
        * * - совпадение > 0 раз
        * ? - совпадегие 0 или 1 раз
        * */
        Pattern pat;
        Matcher mat;
        boolean found;
        boolean find;
        String inputText = "Java";

        pat = Pattern.compile("Java");
        mat = pat.matcher(inputText);
        found = mat.matches();

        System.out.println("Входящая строка: " + inputText);
        System.out.println("Проверка на совпадение 'Java'");
        if(found)
            System.out.println("Совпадение есть!");
        else
            System.out.println("Совпадения нет");

        System.out.println("Проверка на совпадение 'Java 8'");
        mat = pat.matcher("Java 8");
        found = mat.matches();
        find = mat.find();
        if(find)
            System.out.println("Совпадение есть!");
        else
            System.out.println("Совпадения нет");

        inputText = "test 1 2 3 test";
        pat = Pattern.compile("1");
        mat = pat.matcher(inputText);
        while (mat.find()){
            System.out.println("найдено 'test', индекс: " + mat.start());
        }
    }
}
