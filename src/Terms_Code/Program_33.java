package Terms_Code;

// Интерфейсы в преобразованиях типов.
/**
 * Все сказанное в отношении преобразования типов характерно и для интерфейсов.
 * Например, так как класс Journal32 реализует интерфейс Printable32, то
 * переменная типа Printable32 может хранить ссылку на объект типа Journal32.
 * 
 * И если мы хотим обратиться к методам класса Journal32, которые определены не
 * в интерфейсе Printable32, а в самом классе Journal32, то нам надо явным
 * образом выполнить преобразование типов: ((Journal32)p).getName();
 */

public class Program_33 {
    public static void main(String[] args) {
        Printable32 p = new Journal32("Foreign Affairs"); // p - может хранить ссылку на объект типа Journal32
        p.print(); // Foreign Affairs
        // p.getName(); - мы не можем обратиться к методу

        // Интерфейс не имеет метода getName, так как этот метод находиться в классе
        // Journal32, необходимо явное приведение
        String name = ((Journal32) p).getName();
        System.out.println(name); // Foreign Affairs
    }
}
