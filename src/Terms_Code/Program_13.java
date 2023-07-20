package Terms_Code;

/**
 * Статические инициализаторы
 * Статические инициализаторы предназначены для инициализации статических
 * переменных, либо для выполнения таких действий, которые выполняются при
 * создании самого первого объекта.
 * 
 * Статический инициализатор определяется как обычный, только перед ним ставится
 * ключевое слово static. В данном случае в статическом инициализаторе мы
 * устанавливаем начальное значение статического поля counter и выводим на
 * консоль сообщение.
 * 
 * Стоит учитывать, что вызов статического инициализатора производится после
 * загрузки класса и фактически до создания самого первого объекта класса.
 * 
 * Например, определим статический инициализатор:
 */

public class Program_13 {

    public static void main(String[] args) {

        Person13 tom = new Person13();
        Person13 bob = new Person13();

        // System.out.println(tom); // 105
        // System.out.println(bob); // 106

        tom.displayId(); // Id = 105
        bob.displayId(); // Id = 106

        // В самой программе создаются два объекта класса Person.

        // Поэтому консольный вывод будет выглядеть следующим образом:

        // => Static initializer
        // => Constructor
        // => Constructor
        // => Id: 105
        // => Id: 106
    }
}

class Person13 {

    private int id;
    static int counter;

    @Override
    public String toString() {
        return String.format("%d ", id);
    }

    // статический инициализатор:
    static {
        counter = 105;
        System.out.println("Static initializer");
    }

    Person13() {
        id = counter++;
        System.out.println("Constructor");
    }

    public void displayId() {

        System.out.printf("Id: %d \n", id);
    }
}
