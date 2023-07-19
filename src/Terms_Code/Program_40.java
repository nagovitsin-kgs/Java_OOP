package Terms_Code;

// Вложенные интерфейсы.

/**
 * Как и классы, интерфейсы могут быть вложенными, то есть могут быть определены
 * в классах или других интерфейсах. Например:
 */

public class Program_40 {

    // Использование интерфейса будет аналогично предыдущим случаям:
    public static void main(String[] args) {

        Printer40.Printable40 p = new Journal40("Foreign Affairs");
        p.print(); // Foreign Affairs

    }
}

// Как и классы, интерфейсы могут быть вложенными, то есть могут быть определены
// в классах или других интерфейсах. Например:

class Printer40 { // в класс вложен интерфейс

    interface Printable40 {

        void print();
    }
}

// При применении такого интерфейса нам надо указывать его полное имя вместе с
// именем класса:

class Journal40 implements Printer40.Printable40 { // реализуем интерфейс, который вложенный в класс

    String name;

    Journal40(String name) {

        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }
}