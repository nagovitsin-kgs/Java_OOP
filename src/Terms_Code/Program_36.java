package Terms_Code;
// Приватные методы в интерфейсах.

/**
 * По умолчанию все методы в интерфейсе фактически имеют модификатор public.
 * Однако начиная с Java 9 мы также можем определять в интерфейсе методы с
 * модификатором private. Они могут быть статическими и нестатическими, но они
 * не могут иметь реализации по умолчанию.
 * 
 * Подобные методы могут использоваться только внутри самого интерфейса, в
 * котором они определены. То есть к примеру нам надо выполнять в интерфейсе
 * некоторые повторяющиеся действия, и в этом случае такие действия можно
 * выделить в приватные методы:
 */

public class Program_36 {

    public static void main(String[] args) {
        // Мы реализуем через интерфейс в пустом классе
        Calculatable_Interface c = new Calculation_Class();
        System.out.println(c.sum(1, 2)); // 3
        System.out.println(c.sum(1, 2, 4)); // 7

        // будет работать если метод sumAll(int... values) будет default
        // System.out.println(c.sumAll(1, 2, 3, 4, 5));
    }
}

class Calculation_Class implements Calculatable_Interface {
    // пустой будет исполнять реализацию методов из интерфейса
}

interface Calculatable_Interface {

    default int sum(int a, int b) {
        return sumAll(a, b);
    }

    default int sum(int a, int b, int c) {
        return sumAll(a, b, c);
    }

    private int sumAll(int... values) { // не статический private метод, без реализации по умолчанию
        int result = 0;
        for (int n : values) {
            result += n;
        }
        return result;
    }
    // Что такое три точки в Java?
    // Кратко главное Конкретно в этом случае три точки — это оператор расширения.
    // Он «разбивает» объект на набор его элементов и отдаёт их по порядку. Можно
    // представить, что если объект — это набор чего-то в обёртке, то оператор
    // расширения надрывает эту обёртку, и из объекта всё высыпается.
}
