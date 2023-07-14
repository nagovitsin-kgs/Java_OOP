package Terms_Code;

public class Program_04 {

    public static void main(String[] args) {

        Person4 undef = new Person4();
        undef.displayInfo(); // Name: Undefined Age: 18

        Person4 tom = new Person4("Tom");
        tom.displayInfo(); // Name: Tom Age: 18

        Person4 sam = new Person4("Sam", 25);
        sam.displayInfo(); // Name: Sam Age: 25
    }
}

class Person4 {

    String name; // имя
    int age; // возраст

    Person4() {
        this("Undefined", 18);
    }

    Person4(String name) {
        this(name, 18);
    }

    Person4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.printf("Name: %s\t \tAge: %d\n", name, age);
    }
}
