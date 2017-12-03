package Reflection.example.first;

/**
 * Created by USER on 30.11.2017.
 */
public class DBInfoBuilder implements InfoBuilder {
    @Override
    public Information buildInformation() {
        System.out.println("Получение информации из базы данных");
        return new Information();
    }
}
