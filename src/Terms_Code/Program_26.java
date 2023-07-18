package Terms_Code;

// Динамическая диспетчеризация методов
/**
 * Наследование и возможность переопределения методов открывают нам большие
 * возможности.
 * 
 * Прежде всего мы можем передать переменной суперкласса(базовый, родительский)
 * ссылку на объект подкласса(произ-й класс, наследник):
 * 
 * Person sam = new Employee26("Sam", "Oracle");
 * 
 * Так как Employee26 наследуется от Person26, то объект Employee26 является в
 * то же время и объектом Person26.
 * Грубо говоря, любой работник предприятия одновременно является человеком.
 * 
 * Однако несмотря на то, что переменная представляет объект Person26,
 * виртуальная машина видит, что в реальности она указывает на объект
 * Employee26.
 * Поэтому при вызове методов у этого объекта будет вызываться та версия метода,
 * которая определена в классе Employee26, а не в Person26.
 * 
 * Например (ниже):
 * 
 * Итого:
 * 
 * При вызове переопределенного метода виртуальная машина динамически находит и
 * вызывает именно ту версию метода, которая определена в подклассе(Employee26).
 * Данный процесс еще называется dynamic method lookup или динамический поиск
 * метода или динамическая диспетчеризация методов.
 */

public class Program_26 {

    public static void main(String[] args) {

        Person26 tom = new Person26("Tom");
        tom.display(); // Person Tom
        Person26 sam = new Employee26("Sam", "Oracle");
        sam.display(); // Employee Sam works in Oracle
    }
}

class Person26 {

    String name;

    public String getName() {
        return name;
    }

    public Person26(String name) {

        this.name = name;
    }

    public void display() {

        System.out.printf("Person %s \n", name);
    }
}

class Employee26 extends Person26 {

    String company;

    public Employee26(String name, String company) {

        super(name); // вызов конструктора из суперкласса Person26
        this.company = company;
    }

    @Override
    public void display() { // переопределили метод суперкласса Person26

        System.out.printf("Employee %s works in %s \n", super.getName(), company);
        // super.getName() - вызываем метод из суперкдасса Person26, company из
        // подкласса Employee26
    }
}
