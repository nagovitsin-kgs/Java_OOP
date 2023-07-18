package Terms_Code;

// Наследование.
// Переопределение методов:
/**
 * Производный класс может определять свои методы, а может переопределять
 * методы, которые унаследованы от базового класса. Например, переопределим в
 * классе Employee23 метод display.
 * 
 * Перед переопределяемым методом указывается аннотация @Override. Данная
 * аннотация в принципе необязательна.
 * 
 * При переопределении метода он должен иметь уровень доступа не меньше, чем
 * уровень доступа в базовом классе. Например, если в базовом классе метод имеет
 * модификатор public, то и в производном классе метод должен иметь модификатор
 * public.
 */

public class Program_23 {

    public static void main(String[] args) {

        Employee23 sam = new Employee23("Sam", "Microsoft");
        sam.display(); // Name: Sam
                       // Works in Microsoft
    }
}

class Person23 { // базовый класс

    String name;

    public String getName() {
        return name;
    }

    public Person23(String name) {

        this.name = name;
    }

    public void display() {

        System.out.println("Name: " + name);
    }
}

class Employee23 extends Person23 { // наследник, произ-й класс

    String company;

    public Employee23(String name, String company) { // экземпляр проз-го класса

        super(name); // вызов конструктора базового Person23
        this.company = company;
    }

    @Override
    public void display() { // переопределение метода базового класса

        System.out.printf("Name: %s \n", getName());
        System.out.printf("Works in %s \n", company);
    }
}