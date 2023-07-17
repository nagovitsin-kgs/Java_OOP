package Terms_Code;

// Статические поля
/**
 * При создании объектов класса для каждого объекта создается своя копия
 * нестатических обычных полей. А статические поля являются общими для всего
 * класса. Поэтому они могут использоваться без создания объектов класса.
 * 
 * Например, создадим статическую переменную:
 */
public class Program_11 {
    public static void main(String[] args) {

        Person11 tom = new Person11();
        Person11 bob = new Person11();

        tom.displayId(); // Id = 1
        bob.displayId(); // Id = 2
        System.out.println(Person11.counter); // 3

        // изменяем Person.counter
        Person11.counter = 8;

        Person11 sam = new Person11();
        sam.displayId(); // Id = 8
        System.out.println(Person11.counter); // 9

        // Класс Person содержит статическую переменную counter, которая увеличивается в
        // конструкторе и ее значение присваивается переменной id. То есть при создании
        // каждого нового объекта Person эта переменная будет увеличиваться, поэтому у
        // каждого нового объекта Person значение поля id будет на 1 больше чем у
        // предыдущего.

        // Так как переменная counter статическая, то мы можем обратиться к ней в
        // программе по имени класса:
        // System.out.println(Person.counter); // получаем значение
        // Person.counter = 8; // изменяем значение
    }

}

class Person11 {

    private int id;
    static int counter = 1; // статическое поле

    Person11() {
        id = counter++;
    }

    public void displayId() {

        System.out.printf("Id: %d \n", id);
    }
}
