package lambda_expressions.eight;

/**
 * Created by USER on 01.12.2017.
 */
interface MyFunc<T>{
    boolean func(T v1, T v2);
}

class HighTemp{
    private int hTemp;

    HighTemp(int ht){
        hTemp = ht;
    }

    boolean sameTemp(HighTemp ht2){
        return hTemp == ht2.hTemp;
    }

    boolean lessThanTemp(HighTemp ht2){
        return  hTemp < ht2.hTemp;
    }
}
public class Main {

    static <T> int counter(T[] vals, MyFunc<T> f, T v){
        int count = 0;
        for(int i = 0; i < vals.length;i++){
            if(f.func(vals[i], v))
                count++;
        }
        return  count;
    }

    public static void main(String[] args) {
        int count;
        HighTemp[]weekDayHighs = {new HighTemp(89),new HighTemp(82),
                                    new HighTemp(90), new HighTemp(89),
                                    new HighTemp(89),new HighTemp(75),
                                    new HighTemp(83)};
        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была 89 градусов: " + count);

        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println("Дней, когда температура была меньше чем 89 градусов: " + count);
    }
}
