package Terms_Code;

// Оператор instanceof (проверяет, является ли переменная объектом типа)
/**
 * Примеры нисходящих перобразований:
 * 
 * Object kate = new Client30("Kate", "DeutscheBank", 2000);
 * ((Person30) kate).display(); // Client Kate has account in DeutscheBank
 * 
 * Object sam = new Employee30("Sam", "Oracle");
 * ((Employee30) sam).display(); // Employee Sam works in Oracle
 * 
 * Но рассмотрим еще одну ситуацию:
 * 
 * Object kate = new Client30("Kate", "DeutscheBank", 1000);
 * Employee30 emp = (Employee30) kate;
 * emp.display();
 * или так:
 * ((Employee30) kate).display();
 * 
 * В данном случае переменная типа Object хранит ссылку на объект Client30.
 * Мы можем без ошибок привести этот объект к типам Person30 или Client30.
 * Но при попытке преобразования к типу Employee30 мы получим ошибку во время
 * выполнения.
 * Так как kate не представляет объект типа Employee30.
 * 
 * Оператор instanceof:
 * 
 * В примере выше мы явно видим, что переменная kate - это ссылка на объект
 * Client30, а не Employee30.
 * Однако нередко данные приходят извне, и мы можем точно не знать, какой именно
 * объект эти данные представляют.
 * Соответственно возникает большая вероятность столкнуться с ошибкой.
 * И перед тем, как провести преобразование типов, мы можем проверить, а можем
 * ли мы выполнить приведение с помощью оператора instanceof:
 */

public class Program_30 {
    public static void main(String[] args) {

        // 1). Выражение kate instanceof Employee30 вернёт false:

        // нисходящее преобразование от Object к типу Employee30:
        Object kate = new Client30("Kate", "DeutscheBank", 2000);

        if (kate instanceof Employee30) {

            Employee30 employeeKate = (Employee30) kate;
            employeeKate.display();
        } else {

            System.out.println("Conversion is invalid"); // Conversion is invalid
        }
        // Выражение kate instanceof Employee30 проверяет, является ли переменная kate
        // объектом типа Employee30.
        // Но так как в данном случае явно не является, то такая проверка вернет
        // значение false, и преобразование не сработает.

        // 2). Выражение kat instanceof Client30 возвратило бы true:

        // нисходящее преобразование от Object к типу Client30:
        Object kat = new Client30("Kat", "DeutscheBank", 1000);

        if (kat instanceof Client30) {

            Client30 clientKat = (Client30) kat;
            clientKat.display(); // Client Kat has account in DeutscheBank
        } else {

            System.out.println("Conversion is invalid");
        }
        // Выражение kat instanceof Client30 проверяет, является ли переменная kat
        // объектом типа Client30.
        // Да является, то такая проверка вернет значение true, и преобразование
        // сработает.

        // 3). !!!Следует отметить, что начиная с версии Java 16 мы можем упростить
        // преобразование типов следующим образом:

        // нисходящее преобразование от Object к типу Client30:
        Object kat1 = new Client30("Kat1", "DeutscheBank", 5000);
        if (kat1 instanceof Client30 clientKat1) {

            clientKat1.display(); // Client Kat1 has account in DeutscheBank
        } else {

            System.out.println("Conversion is invalid");
        }
        // Выражение kat1 instanceof Client30 clientKat1, проверяет, представляет ли
        // переменная kat1 класс Client30, и если представляет (то есть оператор
        // instanceof возвращает true), то создает переменную clientKat1 типа Client30.
        // И в дальнейшем мы можем использовать эту переменную clientKat1 и производить
        // с ней различные операции.
    }
}

// класс человека
class Person30 {

    private String name;

    public String getName() {
        return name;
    }

    public Person30(String name) {

        this.name = name;
    }

    public void display() {

        System.out.printf("Person %s \n", name);
    }
}

// служащий некоторой компании
class Employee30 extends Person30 {

    private String company;

    public Employee30(String name, String company) {

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
class Client30 extends Person30 {

    private int sum; // Переменная для хранения суммы на счете
    private String bank;

    public Client30(String name, String bank, int sum) {

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