package formatter;

import java.util.Calendar;
import java.util.Formatter;

/**
 * Created by USER on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();
//        String inputText = "balbla";
        fmt.format("Форматировать %s просто %d %f", "в Java", 100, 100.523);
        System.out.println(fmt);
        fmt.close();

        //Форматирование чисел
        /*
        * %d - целые числа
        * %f - дробные числа
        * %е - научный формат
        * %x - 16-ричный формат
        * %o - 80ричный формат*/

        fmt = new Formatter();
//        for(double i = 1.23; i < 1.0e+6; i += 100){
//            fmt.format("%f %e", i, i);
//            System.out.println(fmt);
//        }
//        fmt.close();
//        fmt.format("Шестнадцатеричное число:  %x, восьмиричное число: %o", 200, 200);
//        System.out.println(fmt);

        //Форматирование даты
        Formatter dateFmt = new Formatter();
        Calendar cal = Calendar.getInstance();

        fmt.format("%tr", cal);
        System.out.println(dateFmt);

        dateFmt = new Formatter();
        dateFmt.format("%tc", cal);
        System.out.println(dateFmt);

        dateFmt = new Formatter();
        dateFmt.format("%tl:%tM", cal, cal);
        System.out.println(dateFmt);

        dateFmt = new Formatter();
        dateFmt.format("%tB %tb %tm", cal, cal, cal);
        System.out.println(dateFmt);

        dateFmt.close();

        System.out.println();
        fmt.format("Загрузка файла%nзавершена на %d%%", 58);
        System.out.println(fmt);
        fmt.close();

//        fmt = new Formatter();
        for(int i = 1; i < 10; i++){
            fmt = new Formatter();
            fmt.format("%10d %10d %10d", i, i*i, i*i*i);
            System.out.println(fmt);
            fmt.close();
        }


        fmt = new Formatter();
        fmt.format("%50.0f", 123.1234567);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%.2e", 123.1234567);
        System.out.println(fmt);
        fmt.close();
    }
}
