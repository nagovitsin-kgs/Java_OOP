package Terms_Code;

// Определение интерфейса (interface => для использование => ключевое слово implements).
// Что такое интерфейс Java простыми словами?
// Интерфейс это конструкция языка Java, в рамках которой принято описывать абстрактные 
// публичные ( abstract public ) методы и статические константы ( final static ). 
// С помощью интерфейса можно указать, что именно должен выполнять класс его реализующий, 
// но не как это делать. Способ реализации выбирает сам класс.
/**
 * Интерфейс – это ссылочный тип в Java. Он схож с классом. Это совокупность
 * абстрактных методов. Класс реализует интерфейс, таким образом наследуя
 * абстрактные методы интерфейса.
 * 
 * Механизм наследования очень удобен, но он имеет свои ограничения. В частности
 * мы можем наследовать только от одного класса, в отличие, например, от языка
 * С++, где имеется множественное наследование.
 * 
 * В языке Java подобную проблему частично позволяют решить интерфейсы.
 * Интерфейсы определяют некоторый функционал, !не имеющий конкретной
 * реализации, который затем реализуют классы, применяющие эти интерфейсы. И
 * !один класс может применить !множество интерфейсов.
 * 
 * Чтобы определить интерфейс, используется ключевое слово interface.
 * Например:
 * interface Printable{
 * void print();
 * }
 * Данный интерфейс называется Printable. Интерфейс может !определять константы
 * и методы, которые !могут иметь, а !могут и не иметь реализации. Методы без
 * реализации похожи на абстрактные методы абстрактных классов. Так, в данном
 * случае объявлен один метод, который не имеет реализации.
 * 
 * Все !методы интерфейса не имеют модификаторов доступа, но фактически по
 * умолчанию доступ !public, так как !цель интерфейса - определение функционала
 * для реализации его классом. Поэтому весь функционал должен быть !открыт для
 * реализации.
 * 
 * Чтобы класс применил интерфейс, надо использовать ключевое слово implements:
 * implements(реализует)
 */

public class Program_31 {

    public static void main(String[] args) {

        Book31 b1 = new Book31("Java. Complete Referense.", "H. Shildt");
        b1.print(); // Java. Complete Referense. (H. Shildt)

        // В данном случае класс Book реализует интерфейс Printable. При этом надо
        // учитывать, что если класс применяет интерфейс, то он !должен реализовать все
        // методы интерфейса, как в случае выше реализован метод print. Потом в методе
        // main мы можем создать объект класса Book и вызвать его метод print. Если
        // !класс не реализует какие-то методы интерфейса, то такой !класс должен быть
        // определен как абстрактный, а его !неабстрактные классы-наследники затем
        // должны будут реализовать эти !методы.

        // В тоже время мы !не можем напрямую создавать объекты интерфейсов, поэтому
        // следующий код не будет работать:
        // Printable31 pr = new Printable31();
        // pr.print();
    }
}

interface Printable31 { // Интерфейс Printable31

    void print();
}

class Book31 implements Printable31 { // Класс Book31 применяет интерфейс и реализует (implements)

    String name;
    String author;

    Book31(String name, String author) {

        this.name = name;
        this.author = author;
    }

    public void print() {

        System.out.printf("%s (%s) \n", name, author);
    }
}