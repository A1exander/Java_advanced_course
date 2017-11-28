package example.properties.third;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by USER on 27.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        String propPath = "config.properties";
        FileInputStream fis = null;
        Properties props = new Properties();

        try{
            fis = new FileInputStream(propPath);
            props.load(fis);
            String username = props.getProperty("user");
            String login = props.getProperty("login");
            String password = props.getProperty("password");

            System.out.println("username: " + username + "\n" +
                                "login: " + login + "\n" +
                                "password: " + password + "\n");
        }catch (IOException e){
            System.out.println("что-то пошло не так...");
        }
    }
}
