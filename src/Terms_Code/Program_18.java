package Terms_Code;

// Внутренние и вложенные классы
/**
 * Классы могут быть вложенными (nested), то есть могут быть определены внутри
 * других классов. Частным случаем вложенных классов являются внутренние классы
 * (inner class).
 * 
 * Внутренний класс ведет себя как обычный класс за тем исключением, что его
 * объекты могут быть созданы только внутри внешнего класса.
 * 
 * Внутренний класс имеет доступ ко всем полям внешнего класса, в том числе
 * закрытым с помощью модификатора private. Аналогично внешний класс имеет
 * доступ ко всем членам внутреннего класса, в том числе к полям и методам с
 * модификатором private.
 * 
 * Ссылку на объект внешнего класса из внутреннего класса можно получить с
 * помощью выражения Внешний_класс.this, например, Person.this.
 * 
 * Объекты внутренних классов могут быть созданы только в том классе, в котором
 * внутренние классы опеределены. В других внешних классах объекты внутреннего
 * класса создать нельзя.
 * 
 * Например, имеется класс Person18, внутри которого определен класс Account:
 */
public class Program_18 {
    public static void main(String[] args) {

        Person18 tom = new Person18("Tom", "qwerty");
        tom.displayPerson(); // Person Name: Tom Password: qwerty
        tom.account.displayAccount(); // Account Login: Tom Password: qwerty
    }
}

class Person18 { // внешний класс

    private String name;
    Account account; // определяем внутренний вложенный класс

    Person18(String name, String password) {
        this.name = name;
        account = new Account(password);
    }

    public void displayPerson() {
        System.out.printf("Person \t Name: %s \t Password: %s \n", name, account.password);
    }

    public class Account { // внутренний класс
        private String password;

        Account(String pass) {
            this.password = pass;
        }

        void displayAccount() {
            System.out.printf("Account Login: %s \t Password: %s \n", Person18.this.name, password);
            // ссылку на объект внешнего класса из внутреннего класса => Person18.this.name
        }
    }
}
