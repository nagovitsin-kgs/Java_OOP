package Terms_Code;
// Наследование.

// Использование классов Person21 и Employee21:

public class Program_21 {
    public static void main(String[] args) {

        Person21 tom = new Person21("Tom"); // создали объект базового класса, конструктор
        tom.display(); // Name: Tom // имя из базового класса

        Employee21 sam = new Employee21("Sam"); // создали конструктор произ-го класса
        sam.display(); // Name: Sam // имя из произ-го класса
    }
}

// _____________________________________________________________________

// Ниже классы базовый и наследник расположены по разным файлам это правильно,
// будет работать и в одном.

// Базовый, родительский, суперкласс:
// class Person21 {

// String name;

// public String getName() {
// return name;
// }

// public Person21(String name) {

// this.name = name;
// }

// public void display() {

// System.out.println("Name: " + name);
// }
// }

// Наследник, подкласс, производный класс от базового Person21:
// class Employee21 extends Person21 {
// public Employee21(String name) {
// super(name); // если базовый класс определяет конструктор
// // то производный класс должен его вызвать
// }
// }
