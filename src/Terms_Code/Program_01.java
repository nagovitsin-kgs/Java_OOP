package Terms_Code;

// Оба класса расположены в одном пакете по умолчанию, пакет - в одном файле.
// В данном случае оба класса расположены в одном пакете - пакете по умолчанию,
// поэтому в классе Program_01 мы можем использовать все методы и переменные класса Person,
// которые имеют модификатор по умолчанию, public и protected.
// А поля и методы с модификатором private в классе Program_01 не будут доступны.
// Если бы класс Program_01 располагался бы в другом пакете, то ему были бы доступны только поля и методы с модификатором public.
// Модификатор доступа должен предшествовать остальной части определения переменной или метода.

/**
 * public: публичный, общедоступный класс или член класса.
 * Поля и методы, объявленные с модификатором public, видны другим классам из
 * текущего пакета и из внешних пакетов.
 * private: закрытый класс или член класса, противоположность модификатору
 * public.
 * Закрытый класс или член класса доступен только из кода в том же классе.
 */
public class Program_01 {
    /**
     * Ключевое слово main() - основной метод.
     * Это - строка, с которой начинается выполнение программы.
     * Все приложения Java должны иметь один метод main().
     * 1). public - доступен для всех из любого класса и пакета (из всей программы).
     * 2). static - т. е это идентификатор означающий что наш метод ну или поле в
     * единственном экземпляре.
     */
    public static void main(String[] args) {

        Person kate = new Person("Kate", 32, "Baker Street", "+12334567");
        kate.displayName(); // норм, метод public // => Name: Kate
        kate.displayAge(); // норм, метод имеет модификатор по умолчанию // => Age: 32
        kate.displayPhone(); // норм, метод protected // => Phone: +12334567
        // kate.displayAddress(); // => ! Ошибка, метод private

        System.out.println(kate.name); // норм, модификатор по умолчанию // => Kate
        System.out.println(kate.address); // норм, модификатор public // => Baker Street
        System.out.println(kate.age); // норм, модификатор protected // => 32
        // System.out.println(kate.phone); // ! Ошибка, модификатор private
        System.out.println(kate);

    }

}

/**
 * Класс Человек, личность, лицо.
 * класс — это тот самый blueprint (план) в мире java, по которому будут
 * создаваться объекты. Класс состоит из кода, который хранится в
 * соответствующем файле. На основе этих строк будут создаваться объекты.
 * Члены класса — это основные элементы, которые может содержать в себе класс.
 */
class Person {

    String name;
    protected int age;
    public String address;
    private String phone;

    // сам переопределил метод:
    @Override
    public String toString() {
        return String.format("%s %d %s %s ", name, age, address, phone);
    }

    /**
     * public Метод: Person.
     * Принимает объекты в поле класса Person, переменные: name, age, address,
     * phone.
     * В теле ссылка (this) в этом классе на переменные с присвоением.
     */
    public Person(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Метод public: Отображать имя. Печать name.
     */
    public void displayName() {
        System.out.printf("Name: %s \n", name);
    }

    /**
     * По умолчанию Метод: Отображать возраст. Печать Age.
     * Метод по умолчанию это - public.
     */
    void displayAge() {
        System.out.printf("Age: %d \n", age);
    }

    /**
     * private Метод: Отображать адрес. Печать address.
     */
    private void displayAddress() {
        System.out.printf("Address: %s \n", address);
    }

    /**
     * protected Метод: Отображать телефон. Печать phone.
     */
    protected void displayPhone() {
        System.out.printf("Phone: %s \n", phone);
    }

}
