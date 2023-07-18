package Terms_Code;

// Наследование.
/**
 * Одним из ключевых аспектов объектно-ориентированного программирования
 * является наследование. С помощью наследования можно расширить функционал уже
 * имеющихся классов за счет добавления нового функционала или изменения
 * старого.
 * 
 * Например, имеется следующий класс Person, описывающий отдельного
 * человека:
 */

public class Person21 {
    String name;

    public String getName() {
        return name;
    }

    public Person21(String name) { // это экземпляр класса, это = new Person21(...)
        this.name = name;
    }

    public void display() {

        System.out.println("Name: " + name);
    }
}
