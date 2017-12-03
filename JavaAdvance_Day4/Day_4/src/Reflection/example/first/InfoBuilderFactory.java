package Reflection.example.first;

import java.util.PropertyResourceBundle;

/**
 * Created by USER on 30.11.2017.
 */
public class InfoBuilderFactory {

    public static InfoBuilder getInfoBuilder(){
        PropertyResourceBundle pr = (PropertyResourceBundle)
                PropertyResourceBundle.getBundle("Reflection.example.first.builder");
        String className = pr.getString("builder.class");

        try {
            Class cl = Class.forName(className);
            InfoBuilder builder = (InfoBuilder)cl.newInstance();
            return builder;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
