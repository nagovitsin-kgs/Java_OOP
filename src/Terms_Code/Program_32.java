package Terms_Code;

// Динамическое создание объектов с типом интерфейс в программе как экземпляры обоих классов.
/**
 * Класс Book32 и класс Journal32 !связаны тем, что они !реализуют интерфейс
 * Printable32.
 * 
 * Поэтому мы динамически в программе можем создавать объекты
 * Printable32 как экземпляры обоих классов:
 */
public class Program_32 {

    public static void main(String[] args) {

        // создаём объекты Printable32 как экземпляры обоих классов:
        Printable32 printable = new Book32("Java. Complete Reference", "H. Shildt");
        printable.print(); // Java. Complete Reference (H. Shildt)
        printable = new Journal32("Foreign Policy");
        printable.print(); // Foreign Policy

    }
}

interface Printable32 { // интерфейс32

    void print();
}

class Book32 implements Printable32 { // Класс книга32 реализует интерйейс32

    String name;
    String author;

    Book32(String name, String author) {

        this.name = name;
        this.author = author;
    }

    public void print() {

        System.out.printf("%s (%s) \n", name, author);
    }
}

class Journal32 implements Printable32 { // Класс журнал32 реализует интерйейс32

    private String name;

    String getName() {
        return name;
    }

    Journal32(String name) {

        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }
}
