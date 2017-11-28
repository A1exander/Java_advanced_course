package example.Object;

/**
 * Created by USER on 27.11.2017.
 */
public class Main {
    int a, b;
    String name;

    Main(int a, int b, String name){
        this.a = a;
        this.b = b;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Object: " + name + "\n" +
                "properties: " + a +" , " + b;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    public static void main(String[] args) {
        Main m_1 = new Main(5, 5, "First");
        Main m_2 = new Main(5, 5, "First");
        System.out.println("Строковое объектов");
        System.out.println("m_1: " + m_1.toString());
        System.out.println("m_2: " + m_2.toString());
        System.out.println("Хэш-код объектов");
        System.out.println("m1_hash: " + m_1.hashCode());
        System.out.println("m2_hash: " + m_2.hashCode());
    }
}
