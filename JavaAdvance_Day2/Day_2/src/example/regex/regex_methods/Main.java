package example.regex.regex_methods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by USER on 28.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        //replaceAll()
        String inputStroke = "мама мыла раму мама мамачистила раму";
        Pattern pat = Pattern.compile("мама.*?");
        Matcher mat = pat.matcher(inputStroke);
        System.out.println("Исходная строка: " + inputStroke);
        inputStroke = mat.replaceAll("папа");
        System.out.println("Измененная строка: " + inputStroke);

        //split
        inputStroke = "one two, blabla 123 !okay.blabla";
        String[]strokes;
        pat = Pattern.compile("[,.!]");
        strokes = pat.split(inputStroke);

        for(String subStr : strokes){
            System.out.println("Лексема: " + subStr);
        }

        //appendReplacement() и appendTail()
        inputStroke = "аддаадJavaааддsAmazingадProgrammingдLanguageад";
        String regex = "а*д";
        String replace = "-";
        pat = Pattern.compile(regex);
        mat = pat.matcher(inputStroke);
        StringBuffer sb = new StringBuffer();
        while (mat.find()){
            mat.appendReplacement(sb, replace);
        }
        mat.appendTail(sb);
        System.out.println(sb.toString());
    }
}
