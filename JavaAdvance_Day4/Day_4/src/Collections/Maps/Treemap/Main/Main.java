package Collections.Maps.Treemap.Main;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by USER on 30.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        TreeMap<String, Double> hm = new TreeMap<>();
        hm.put("Иван Петров", new Double(150.50));
        hm.put("Мария Соколова", new Double(135.568));
        hm.put("Афанасий Иванов", new Double(120));
        hm.put("Александр Сидоров", new Double(1));


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
