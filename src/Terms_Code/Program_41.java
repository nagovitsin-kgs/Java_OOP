package Terms_Code;
// Интерфейсы как параметры и результаты методов.

/**
 * И также как и в случае с классами, интерфейсы могут использоваться в качестве
 * !типа параметров метода или в качестве !возвращаемого типа.
 * 
 * Метод read() в качестве параметра принимает объект интерфейса Printable41,
 * поэтому в этот метод мы можем передать как объект Book41, так и объект
 * Journal41.
 * 
 * Метод createPrintable() возвращает объект Printable41, поэтому также мы можем
 * возвратить как объект Book41, так и Journal41.
 */

public class Program_41 {

    public static void main(String[] args) {

        Printable41 printable = createPrintable("Foreign Affairs", false);
        printable.print(); // Foreign Affairs

        read(new Book41("Java for impatients", "Cay Horstmann")); // Java for impatients (Cay Horstmann)
        read(new Journal41("Java Dayly News")); // Java Dayly News
    }

    // также как и в случае с классами, интерфейсы могут использоваться в качестве
    // !типа параметров метода:
    static void read(Printable41 p) {

        p.print();
    }

    // также как и в случае с классами, интерфейсы могут использоваться в качестве
    // !возвращаемого типа:
    static Printable41 createPrintable(String name, boolean option) {

        if (option)
            return new Book41(name, "Undefined");
        else
            return new Journal41(name);
    }
}

interface Printable41 {

    void print();
}

class Book41 implements Printable41 {

    String name;
    String author;

    Book41(String name, String author) {

        this.name = name;
        this.author = author;
    }

    public void print() {

        System.out.printf("%s (%s) \n", name, author);
    }
}

class Journal41 implements Printable41 {

    private String name;

    String getName() {
        return name;
    }

    Journal41(String name) {

        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }
}
