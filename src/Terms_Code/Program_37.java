package Terms_Code;

// Константы в интерфейсах.
/**
 * Кроме методов в интерфейсах могут быть определены статические константы:
 * interface Stateable{
 * 
 * int OPEN = 1;
 * int CLOSED = 0;
 * 
 * void printState(int n);
 * 
 * }
 * Хотя такие константы также не имеют модификаторов, но по умолчанию они имеют
 * модификатор доступа !public static final!, и поэтому их значение !доступно из
 * любого места программы.
 * 
 * Применение констант:
 */

public class Program_37 {

    public static void main(String[] args) {

        WaterPipe37 pipe = new WaterPipe37();
        pipe.printState(1); // Water is opened
        // Мы обратились к типу класса WaterPipe37, создали конструктор в этом классе,
        // затем реализовали метод (переопределенный) с помощью констант из интерфейса
    }
}

class WaterPipe37 implements Stateable37 { // класс водопроводная труба

    public void printState(int n) { // метод состояние печати
        if (n == OPEN)
            System.out.println("Water is opened"); // Water is opened (Вода открыта)
        else if (n == CLOSED)
            System.out.println("Water is closed"); // Water is closed (Вода закрыта)
        else
            System.out.println("State is invalid"); // State is invalid (Состояние не действительно)
    }
}

interface Stateable37 { // Интерфейс (состояние) с константами и абстактным методом

    int OPEN = 1; // константа с модификатор доступа всегда по умолчанию public static final
    int CLOSED = 0; // константа с модификатор доступа всегда по умолчанию public static final

    void printState(int n); // метод состояние печати, модификатор по умолчанию всегда public, абстрактный
                            // метод, который обязательно нужно использовать в классе WaterPipe37. Не
                            // использовать можно, когда метод в интерфейсе - default
}
