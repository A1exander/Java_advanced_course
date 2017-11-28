package example.properties.first;

import java.util.Properties;
import java.util.Set;

/**
 * Created by USER on 27.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        Properties userProps = new Properties();
        userProps.put("Ivanov", "Ivan");
        userProps.put("Petrov", "Nikolay");
        userProps.put("Sidorov", "Petr");
        userProps.put("Sokolova", "Maria");

        Set<?>surnames = userProps.keySet();
        for(Object surname: surnames){
            System.out.println("surname: " + surname +" - name: " +
                                userProps.getProperty((String)surname));
        }
    }
}
