package example.regex.metasymbols_quantors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by USER on 28.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        //Применение регулярных выражений с метасимволами и кванторами
        String inputStroke = "123W WW WWW 123 W";
        Pattern pat = Pattern.compile("W+");
        Matcher mat = pat.matcher(inputStroke);
        while(mat.find()){
            System.out.println("Совпадение: " + mat.group());
        }

        inputStroke = "extends blabla end table";
        pat = Pattern.compile("e.+?d");
        mat = pat.matcher(inputStroke);

        System.out.println("Поиск от e до d в :" + inputStroke);
        while(mat.find()){
            System.out.println("Совпадение: " + mat.group());
        }

        inputStroke = "this is a test.123";
        pat = Pattern.compile("[a-b]+");
        mat = pat.matcher(inputStroke);
        System.out.println("input stroke: " + inputStroke);
        while (mat.find()){
            System.out.println("Совпадение: " + mat.group());
        }
    }
}
