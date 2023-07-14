package Terms_Code;

// Кроме конструктора начальную инициализацию объекта вполне можно было проводить с помощью инициализатора объекта.
// Инициализатор выполняется до любого конструктора.
// То есть в инициализатор мы можем поместить код, общий для всех конструкторов:

public class Program_05 {

    public static void main(String[] args) {

        Person5 undef = new Person5();
        undef.displayInfo(); // Name: Undefined Age: 18

        Person5 tom = new Person5("Tom");
        tom.displayInfo(); // Name: Tom Age: 18

        Person5 sam = new Person5("sam", 25);
        sam.displayInfo(); // Name: sam Age: 25
    }
}

class Person5 {

    String name; // имя
    int age; // возраст

    /* начало блока инициализатора */
    {
        name = "Undefined";
        age = 18;
    }

    /* конец блока инициализатора */
    Person5() {

    }

    Person5(String name) {

        this.name = name;
    }

    Person5(String name, int age) {

        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.printf("Name: %s\t \tAge: %d\n", name, age);
    }
}
