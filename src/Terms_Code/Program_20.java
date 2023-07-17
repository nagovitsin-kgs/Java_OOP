package Terms_Code;

// Статические вложенные классы.
/**
 * Здесь определен вложенный класс для хранения данных о вычислении факториала.
 * Основные действия выполняет метод getFactorial, который возвращает объект
 * вложенного класса.
 * 
 * И теперь используем классы в методе main:
 */

public class Program_20 {
    public static void main(String[] args) {

        Math20.Factorial fact = Math20.getFactorial(6);
        System.out.printf("Факториал числа %d равен %d \n", fact.getKey(), fact.getResult());
        // Факториал числа 6 равен 720
    }
}
