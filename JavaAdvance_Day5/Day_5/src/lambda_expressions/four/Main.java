package lambda_expressions.four;

/**
 * Created by USER on 01.12.2017.
 */
interface SomeStringFunc {
    String func(String n);
}

class LamdaAsParameter {

    static String stringOp(SomeStringFunc sf, String s) {
        return sf.func(s);
    }
}

public class Main {
    public static void main(String[] args) {
        String inputStroke = "Лямба-выражение очень удобны в использовании";
        String outputStroke;

        System.out.println(inputStroke);
        outputStroke = LamdaAsParameter.stringOp((str) -> str.toUpperCase(), inputStroke);
        System.out.println("after change: " + outputStroke);

        outputStroke = LamdaAsParameter.stringOp((str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        }, inputStroke);

        System.out.println("reverse: " + outputStroke);

        outputStroke = LamdaAsParameter.stringOp((str) -> {
            String result = "";
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != ' '){
                    result += str.charAt(i);
                }
            }
            return result;
        }, inputStroke);

        System.out.println("stroke without spaces: " + outputStroke);
    }
}
