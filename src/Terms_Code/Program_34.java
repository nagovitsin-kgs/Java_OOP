package Terms_Code;

// Методы по умолчанию в интерфейсах.
/**
 * Ранее до JDK 8 при реализации интерфейса мы должны были обязательно
 * реализовать все его методы в классе. А сам интерфейс мог содержать только
 * определения методов без конкретной реализации. В JDK 8 была добавлена такая
 * функциональность как методы по умолчанию. И теперь интерфейсы кроме
 * определения методов могут иметь их реализацию по умолчанию, которая
 * используется, если класс, реализующий данный интерфейс, не реализует метод.
 * Например, создадим метод по умолчанию в интерфейсе Printable34:
 * 
 * Метод по умолчанию - это обычный метод без модификаторов, который помечается
 * ключевым словом default. Затем в классе Journal34 нам необязательно этот
 * метод реализовать, хотя мы можем его и переопределить (то есть добавить его в
 * Journal34):
 */

public class Program_34 {
    public static void main(String[] args) {
        Journal34 jou = new Journal34("Jou");
        System.out.println(jou.getName()); // Jou

        Printable34 book = new Book34("48 Законов Власти", "Роберт Грин");
        book.print(); // Undefined printable
        // выдал Undefined printable, так как надо переопределить метод void print() в
        // классе Journal34 и тогда он напечатает: 48 Законов Власти (Роберт Грин)
    }
}

interface Printable34 {

    default void print() {

        System.out.println("Undefined printable");
    }
}

class Journal34 implements Printable34 {

    private String name;

    String getName() {
        return name;
    }

    Journal34(String name) {

        this.name = name;
    }
}

class Book34 implements Printable34 {

    String name;
    String author;

    Book34(String name, String author) {

        this.name = name;
        this.author = author;
    }

    // public void print() {

    // System.out.printf("%s (%s) \n", name, author);
    // }
}