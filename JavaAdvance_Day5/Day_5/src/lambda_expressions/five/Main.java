package lambda_expressions.five;

/**
 * Created by USER on 01.12.2017.
 */
interface DoubleNumericArrayFunc{
    double func(double[]n) throws  EmptyArrayException;
}

class EmptyArrayException extends Exception{
    EmptyArrayException(){
        super("Array is empty");
    }
}
public class Main {
    public static void main(String[] args) {
        double[]values = {1.0,2.0,3.0,4.0,5.0,};
        DoubleNumericArrayFunc average = (n)->{
            double sum = 0;
            if(n.length == 0){
                throw new EmptyArrayException();
            }
            for(int i = 0; i < n.length;i++){
                sum += n[i];
            }
            return sum / n.length;
        };

        try {
            System.out.println("average of values[]: " + average.func(values));
            System.out.println("average of new_arr[0]: " + average.func(new double[0]));
        } catch (EmptyArrayException e) {
            System.out.println("Попытка найти среднее у пустого массива");
        }
    }
}
