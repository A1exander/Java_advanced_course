package Collections.Maps.Hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<String, Double>hm = new HashMap<>();
        hm.put("Иван Петров", new Double(150.50));
        hm.put("Мария Соколова", new Double(135.568));
        hm.put("Афанасий Иванов", new Double(120));
        hm.put("Александр Сидоров", new Double(50));
        hm.put("Анна Галочкина", new Double(55.5));

        Set<Map.Entry<String, Double>> hs = hm.entrySet();
        for(Map.Entry<String, Double>user: hs){
            System.out.print(user.getKey() + ": " + user.getValue() + "\n");
        }
        System.out.println();
        double balance = hm.get("Иван Петров");
        hm.put("Иван Петров", balance + 500);
        System.out.println("Новый остаток по счету у Ивана: " + hm.get("Иван Петров"));
    }
}
