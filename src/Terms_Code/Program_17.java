package Terms_Code;

// Объекты классов, могут передаваться в методы.
// Объекты как параметры методов
/**
 * Объекты классов, как и данные примитивных типов, могут передаваться в методы.
 * Однако в данном случае есть одна особенность - при передаче объектов в
 * качестве значения передается копия ссылки на область в памяти, где расположен
 * этот объект.
 * 
 * !!! В метод changePerson также передается копия ссылки на объект Person17.
 * Однако в самом методе мы изменяем не отдельные значения объекта, а
 * пересоздаем объект с помощью конструктора и оператора new. В результате в
 * памяти будет выделено новое место для нового объекта Person17, и ссылка на
 * этот объект будет присвоена параметру p:
 * 
 * static void changePerson(Person p){
 * p = new Person("Alice"); // p указывает на новый объект
 * p.setName("Ann"); // изменяется новый объект
 * }
 * 
 * !!! То есть после создания нового объекта Person параметр p и переменная kate
 * в методе main будут хранить ссылки на разные объекты. Переменная kate,
 * которая передавалась в метод, продолжит хранить ссылку на старый объект в
 * памяти. Поэтому ее значение не меняется.
 * 
 * 
 * От этого случая (Program_16) следует отличать другой случай:
 */

public class Program_17 {
    public static void main(String[] args) {

        Person17 kate = new Person17("Kate");
        System.out.println(kate.getName()); // Kate
        changePerson(kate);
        System.out.println(kate.getName()); // Kate - изменения не произошло
                                            // kate хранит ссылку на старый объект

    }

    static void changePerson(Person17 p) {
        p = new Person17("Alice"); // p указывает на новый объект
        p.setName("Ann");
    }

    static void changeName(Person17 p) { // только этот метод сработает
        p.setName("Alice");
    }
}

class Person17 {

    private String name;

    Person17(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return this.name;
    }
}
