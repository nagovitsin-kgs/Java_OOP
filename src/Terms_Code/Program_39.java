package Terms_Code;

//Наследование интерфейсов.

/**
 * Интерфейсы, как и классы, могут наследоваться:
 * 
 * При применении этого интерфейса класс Book31 должен будет реализовать как
 * методы интерфейса BookPrintable39, так и методы базового интерфейса
 * Printable31.
 */

public class Program_39 {
    public static void main(String[] args) {
        Book31 b1 = new Book31("Java", "Рогов");
        b1.print(); // Java (Рогов)
        b1.author = "Козлов";
        b1.print(); // Java (Козлов)

    }
}

interface BookPrintable39 extends Printable31 {

    void paint();
}
