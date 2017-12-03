package Reflection.example.first;

/**
 * Created by USER on 30.11.2017.
 */
public class WebInfoBuilder implements  InfoBuilder {
    @Override
    public Information buildInformation() {
        System.out.println("Получение информации из веб-сервиса");
        return new Information();
    }
}
