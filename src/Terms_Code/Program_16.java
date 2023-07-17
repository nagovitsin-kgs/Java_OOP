package Terms_Code;
// Объекты как параметры методов

/**
 * Объекты классов, как и данные примитивных типов, могут передаваться в методы.
 * Однако в данном случае есть одна особенность - при передаче объектов в
 * качестве значения передается копия ссылки на область в памяти, где расположен
 * этот объект.
 * 
 * Здесь в метод changeName передается объект Person16, у которого изменяется
 * имя.
 * Так как в метод будет передаваться копия ссылки на область памяти, в которой
 * находится объект Person16, то переменная kate и параметр p метода changeName
 * будут указывать на один и тот же объект в памяти.
 * Поэтому после выполнения метода у объекта kate, который передается в метод,
 * будет изменено имя с "Kate" на "Alice".
 * 
 * !!! От этого случая следует отличать другой случай:(cм.Program_17)!!!
 * 
 * Рассмотрим небольшой пример (Program_16).
 * Пусть у нас есть следующий класс Person16:
 */
public class Program_16 {
    public static void main(String[] args) {

        Person16 kate = new Person16("Kate");
        System.out.println(kate.getName()); // Kate
        changeName(kate);
        System.out.println(kate.getName()); // Alice
    }

    static void changeName(Person16 p) {
        p.setName("Alice");
    }
}

class Person16 {

    private String name;

    Person16(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return this.name;
    }
}
