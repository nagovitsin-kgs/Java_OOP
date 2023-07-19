package Terms_Code;

// Иерархия наследования и преобразование типов.
/**
 * В прошлой главе говорилось о преобразованиях объектов простых типов. Однако с
 * объектами классов все происходит немного по-другому. Допустим, у нас есть
 * следующая иерархия классов в примере ниже.
 * 
 * В этой иерархии классов можно проследить следующую цепь наследования:
 * Object (все классы неявно наследуются от типа Object) -> Person ->
 * Employee|Client. См. схему в README (Сlass_Hierarchy).
 * 
 * Суперклассы обычно размещаются выше подклассов, поэтому на вершине
 * наследования находится класс Object, а в самом низу Employee и Client.
 * 
 * Объект подкласса также представляет объект суперкласса.
 * Поэтому в программе мы можем написать следующим образом:
 * 
 * Object tom = new Person29("Tom");
 * Object sam = new Employee29("Sam", "Oracle");
 * Object kate = new Client29("Kate", "DeutscheBank", 2000);
 * Person29 bob = new Client29("Bob", "DeutscheBank", 3000);
 * Person29 alice = new Employee29("Alice", "Google");
 * 
 * Моё высказывание:
 * !Где тип Person29 bob и Person29 alice - явно наследуются от родителя
 * Person29, преобразование будет автоматическим - это восходящее преобразование
 * типов!!!
 * !Где тип Object tom, Object sam, Object kate - не явно наследуются от
 * родителя Person29, преобразование не будет автоматически - это необходимо
 * сделать нисходящее преобразование типов!!!
 * 
 * Это так называемое восходящее преобразование (от подкласса внизу к
 * суперклассу вверху иерархии) или upcasting. Такое преобразование
 * осуществляется автоматически!
 * 
 * Обратное не всегда верно. Например, объект Person29 не всегда является
 * объектом Employee или Client. Поэтому нисходящее преобразование или
 * downcasting от суперкласса к подклассу автоматически не выполняется. В этом
 * случае нам надо использовать операцию преобразования типов, ниже в примере.
 */

public class Program_29 {

    public static void main(String[] args) {
        // Тут преобразование автоматически по восходящей:
        // Person29 tom = new Person29("Tom");
        // tom.display(); // Person Tom
        // Person29 sam = new Employee29("Sam", "Oracle");
        // sam.display(); // Employee Sam works in Oracle
        // Person29 bob = new Client29("Bob", "DeutscheBank", 3000);
        // bob.display(); // Client Bob has account in DeutscheBank
        // В 1).случае всё выводиться...

        // 2).
        // нисходящее преобразование от Object к типу Person29:
        Object tom = new Person29("Tom");
        ((Person29) tom).display(); // Person Tom
        System.out.println(((Person29) tom).getName()); // Tom

        Object sam = new Employee29("Sam", "Oracle");
        // нисходящее преобразование от Object к типу Employee29:
        Employee29 emp = (Employee29) sam;
        emp.display(); // Employee Sam works in Oracle
        System.out.println(emp.getCompany()); // Oracle
        // В данном случае переменная sam приводится к типу Employee29.
        // И затем через объект emp мы можем обратиться к функционалу объекта
        // Employee29.
        // Мы можем преобразовать объект Employee29 по всей прямой линии наследования от
        // Object к Employee29.

        Object kate = new Client29("Kate", "DeutscheBank", 2000);
        // нисходящее преобразование от Object к типу Client29:
        // Можем вот так преобразовать:
        ((Person29) kate).display(); // Client Kate has account in DeutscheBank
        System.out.println(((Person29) kate).getName()); // Kate

        // Тут преобразование автоматически по восходящей:
        Person29 bob = new Client29("Bob", "DeutscheBank", 3000);
        bob.display(); // Client Bob has account in DeutscheBank
        Person29 alice = new Employee29("Alice", "Google");
        alice.display(); // Employee Alice works in Google

    }
}

// класс человека
class Person29 {

    private String name;

    public String getName() {
        return name;
    }

    public Person29(String name) {

        this.name = name;
    }

    public void display() {

        System.out.printf("Person %s \n", name);
    }
}

// служащий некоторой компании
class Employee29 extends Person29 {

    private String company;

    public Employee29(String name, String company) {

        super(name);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void display() {

        System.out.printf("Employee %s works in %s \n", super.getName(), company);
    }
}

// класс клиента банка
class Client29 extends Person29 {

    private int sum; // Переменная для хранения суммы на счете
    private String bank;

    public Client29(String name, String bank, int sum) {

        super(name);
        this.bank = bank;
        this.sum = sum;
    }

    public void display() {

        System.out.printf("Client %s has account in %s \n", super.getName(), bank);
    }

    public String getBank() {
        return bank;
    }

    public int getSum() {
        return sum;
    }
}
