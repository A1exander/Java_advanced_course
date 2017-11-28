package example.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by USER on 27.11.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        //Создание строк
        String abc = "abc";
        char[]ch = {'a', 'c', 'c', 15};
        byte[]bytes = {20, 30, 40, 50};
        String abc_2 = new String(abc);
        String abc_3 = new String(ch);
        String abc_4 = new String(bytes);

        String age = "35";
        String name = "Vasya";
        int a = 50;
        int b = 20;
        System.out.println(name + " :" + (a + b) + " лет");

        //Сравнение строк
        String stroke_1 = "abc";
        String stroke_2 = "abc";
        if(stroke_1.equals("aBC")){
            System.out.println("stroke_1 == stroke_2");
        }else{
            System.out.println("stroke_2 != stroke_1");
        }

        //Сортировка строк
        String[] stroke_arr = {"Привет", "как", "у" , "дела", "алексей"};
        for(String word: stroke_arr){
            System.out.print(word + ", ");
        }
        System.out.println();
        System.out.println("stroke_arr[] after sorting: ");
        for(int j  = 0; j < stroke_arr.length; j++){
            for(int i = j + 1; i < stroke_arr.length; i++){
                if(stroke_arr[i].compareToIgnoreCase(stroke_arr[j]) < 0){
                    String tmp = stroke_arr[j];
                    stroke_arr[j] = stroke_arr[i];
                    stroke_arr[i] = tmp;
                }
            }
            System.out.print(stroke_arr[j] + ", ");
        }

        //Поиск индекса символа\подстроки
        String inputStroke = "мама мыла раму, шла саша по шоссе и сосала и мыла сушку";
        System.out.println(inputStroke);
        System.out.println("index of м: " + inputStroke.indexOf('м'));
        System.out.println("index of мыла: " + inputStroke.indexOf("мыла"));
        System.out.println("last index of м: " + inputStroke.indexOf('м'));
        System.out.println("last index of мыла: " + inputStroke.indexOf("мыла"));

        //Нахождение и выделение подстроки
        String testSubtring = "This is a test. This is too";
        String searh = "is";
        String sub = "was";

        String result = "";
        int i = 0;

        do{
            System.out.println(testSubtring);
            i = testSubtring.indexOf(searh);
            if(i != -1){
                result = testSubtring.substring(0, i);
                result = result + sub;
                result = result + testSubtring.substring(i + searh.length());
                testSubtring = result;
            }
        }while(i != -1);

        System.out.println(searh.concat(sub));

        String afterReplace = "Hello".replaceAll("l", "r");
        System.out.println(afterReplace);

        //Тримирование строки
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Введите 'стоп' для выхода");
        System.out.println("Введите имя пользователя");
        do{
            str = br.readLine();
            str = str.trim();
            if(str.equals("Иван")){
                System.out.println("Пользователь " + str + " авторизован");
            }else if(str.equals("Мария")){
                System.out.println("Пользователь " + str + " авторизован");
            }else if(str.equals("Алексей")){
                System.out.println("Пользователь " + str + " авторизован");
            }
        }while (!str.equals("стоп"));
    }
}
