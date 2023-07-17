package Terms_Code;

//import Terms_Code.Program_01;

public class Program_01 {

    public static void main(String[] args) {
        // объявили переменную с типом Person, по умолчанию значение = null
        Person21 tom;
        // делее нам надо создать объект класса (конструктор, коллекцию)
        // Если в классе не определено ни одного конструктора, то для этого класса
        // автоматически создается конструктор без параметров.
    }
}

class Person1 {

    String name; // имя
    int age; // возраст

    void displayInfo() {
        System.out.printf("Name: %s \tAge: %d\n", name, age);
    }
}
