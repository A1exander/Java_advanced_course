package example.regex.groups;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by USER on 28.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        /*метасимволы
            \d - числа 0 - 9
            \s - проблел
            \z - конец
         */
        String inputStroke = "ВОВ закончилась 1945 года 9 мая";
        Pattern pat = Pattern.compile("(.*)(\\d+)(.*)");
        Matcher mat = pat.matcher(inputStroke);
        while(mat.find()){
            System.out.println("группа 1: " + mat.group(0));
            System.out.println("группа 1: " + mat.group(1));
            System.out.println("группа 1: " + mat.group(2));
        }
    }
}
