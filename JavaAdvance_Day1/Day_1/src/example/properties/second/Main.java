package example.properties.second;

import java.io.*;
import java.util.Properties;

/**
 * Created by USER on 27.11.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = null;
        String name, number;
        boolean changed = false;

        try{
            fin = new FileInputStream("phonebook.dat");
        }catch (FileNotFoundException e){
            System.out.println("файла нет");
        }

        try{
            if(fin != null){
                ht.load(fin);
                fin.close();
            }
        }catch (IOException e){
            System.out.println("Ошибка чтения файла");
        }

        do{
            System.out.println("Введите имя контакта, 'выход' для завершения работы");
            name = br.readLine();
            if(name.equals("выход")){
                continue;
            }
            System.out.println("Введите номер контакта");
            number = br.readLine();
            ht.put(name, number);
            changed = true;
        }while (!name.equals("выход"));
        if(changed){
            FileOutputStream fout = new FileOutputStream("phonebook.dat");
            ht.store(fout, "телефонная кника");
            fout.close();
        }

        do{
            System.out.println("введите имя для поиска, 'выход' для завершения работы");
            name = br.readLine();
            if(name.equals("выход")){
                continue;
            }

            number = (String)ht.get(name);
            System.out.println(number);
        }while (!name.equals("выход"));
    }
}
