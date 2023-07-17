package Terms_Code;

// Cтатические вложенные классы.
/**
 * Вызов будет в файле Program_20:
 * 
 * Кроме внутренних классов также могут быть статические вложенные классы.
 * Здесь определен вложенный класс для хранения данных о вычислении факториала.
 * Основные действия выполняет метод getFactorial, который возвращает объект
 * вложенного класса.
 * 
 * Статические вложенные классы позволяют скрыть некоторую комплексную
 * информацию внутри внешнего класса:
 */
class Math20 { // внешний класс

    public static class Factorial { // вложенный статический внутренний класс

        private int result;
        private int key;

        public Factorial(int number, int x) {

            result = number;
            key = x;
        }

        public int getResult() {
            return result;
        }

        public int getKey() {
            return key;
        }
    }

    public static Factorial getFactorial(int x) {

        int result = 1;
        for (int i = 1; i <= x; i++) {

            result *= i;
        }
        return new Factorial(result, x);
    }
}
