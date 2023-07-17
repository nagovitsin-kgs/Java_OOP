package Terms_Code;

// Статические методы
/**
 * Статические методы также относятся ко всему классу в целом. Например, в
 * примере (Program_13) выше статическая переменная counter была доступна извне,
 * и мы могли изменить ее значение вне класса Person13. Сделаем ее недоступной
 * для изменения извне, но доступной для чтения.
 * 
 * Для этого используем статический метод:
 */
public class Program_14 {
    public static void main(String[] args) {

        Person14.displayCounter(); // Counter: 1

        Person14 tom = new Person14();
        Person14 bob = new Person14();

        Person14.displayCounter(); // Counter: 3
    }
}
// Теперь статическая переменная недоступна извне, она приватная. А ее значение
// выводится с помощью статического метода displayCounter. Для обращения к
// статическому методу используется имя класса: Person.displayCounter().

// ! При использовании статических методов надо учитывать ограничения: в
// статических методах мы можем вызывать только другие статические методы и
// использовать только статические переменные!

class Person14 {

    private int id;
    private static int counter = 1;

    Person14() {
        id = counter++;
    }

    // статический метод
    public static void displayCounter() {

        System.out.printf("Counter: %d \n", counter);
    }

    public void displayId() {

        System.out.printf("Id: %d \n", id);
    }
}
