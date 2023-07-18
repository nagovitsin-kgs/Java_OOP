package Terms_Code;

// Наследование.
// Переопределение медодов:
/**
 * Производный класс может определять свои методы, а может переопределять
 * методы, которые унаследованы от базового класса. Например, переопределим в
 * классе Employee24 метод display.
 * 
 * Перед переопределяемым методом указывается аннотация @Override. Данная
 * аннотация в принципе необязательна.
 * 
 * При переопределении метода он должен иметь уровень доступа не меньше, чем
 * уровень доступа в базовом класса. Например, если в базовом классе метод имеет
 * модификатор public, то и в производном классе метод должен иметь модификатор
 * public.
 * !!!!!!!!!!!!!!
 * Однако в данном случае мы видим, что часть метода display в Employee24
 * повторяет действия из метода display базового класса Person24.
 * !!!!!!!!!!!
 * С помощью ключевого слова super мы также можем обратиться к реализации
 * методов базового класса.
 * 
 * Поэтому мы можем сократить класс Employee24:
 */

public class Program_24 {

    public static void main(String[] args) {

        Employee24 sam = new Employee24("Sam", "Microsoft");
        sam.display(); // Name: Sam
                       // Works in Microsoft
    }
}

class Person24 {

    String name;

    public String getName() {
        return name;
    }

    public Person24(String name) {

        this.name = name;
    }

    public void display() {

        System.out.println("Name: " + name);
    }
}

class Employee24 extends Person24 {

    String company;

    public Employee24(String name, String company) {

        super(name); // вызов конструктора базового класса
        this.company = company;
    }

    @Override
    public void display() {

        super.display(); // с помощью super вызываем реализацию метода display() в базовом классе
        System.out.printf("Works in %s \n", company); // создаём для произ-го класса
    }
}