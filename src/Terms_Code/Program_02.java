package Terms_Code;

public class Program_02 {

    public static void main(String[] args) {

        Person2 tom = new Person2(); // создание объекта, конструктора
        tom.displayInfo();

        // изменяем имя и возраст
        tom.name = "Tom";
        tom.age = 34;
        tom.displayInfo();
    }
}

class Person2 {

    String name; // имя
    int age; // возраст

    void displayInfo() {
        System.out.printf("Name: %s \tAge: %d\n", name, age);
    }
}
