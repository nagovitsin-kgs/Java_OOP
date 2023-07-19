package Terms_Code;

// Статические методы в интерфейсах.
/**
 * Начиная с JDK 8 в интерфейсах доступны статические методы - они аналогичны
 * методам класса: (ниже пример Printable35)
 * 
 * Чтобы обратиться к статическому методу интерфейса также, как и в случае с
 * классами, пишут название интерфейса и метод: (ниже пример Program_35)
 */

public class Program_35 {
    public static void main(String[] args) {
        Printable35.read(); // Read printable
    }
}

interface Printable35 {

    void print();

    static void read() {

        System.out.println("Read printable");
    }
}