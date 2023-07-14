package Terms_Code;

public class Program_03 {

    public static void main(String[] args) {
// Конструкторы выполняют инициализацию объекта!
        Person3 bob = new Person3(); // вызов первого конструктора без параметров
        bob.displayInfo(); // Name: Undefined Age: 18

        Person3 tom = new Person3("Tom"); // вызов второго конструктора с одним параметром
        tom.displayInfo(); // Name: Tom Age: 18

        Person3 sam = new Person3("Sam", 25); // вызов третьего конструктора с двумя параметрами
        sam.displayInfo(); // Name: Sam Age: 25
    }
}

class Person3 {

    String name; // имя
    int age; // возраст

    Person3() {
        name = "Undefined";
        age = 18;
    }

    Person3(String n) {
        name = n;
        age = 18;
    }

    Person3(String n, int a) {
        name = n;
        age = a;
    }

    void displayInfo() {
        System.out.printf("Name: %s\t \tAge: %d\n", name, age);
    }
}
