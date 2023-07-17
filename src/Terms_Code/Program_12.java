package Terms_Code;

import java.io.PrintStream;

// Статические константы
// Также статическими бывают константы, которые являются общими для всего класса.

public class Program_12 {
    public static void main(String[] args) {

        double radius = 60;
        System.out.printf("Radisu: %f \n", radius); // Radisu: 60,000000
        System.out.printf("Area: %f \n", Math12.PI * radius); // Area: 188,400000

        // Стоит отметить, что на протяжении всех предыдущих тем уже активно
        // использовались статические константы. В частности, в выражении:
        // F12 на out => public static final PrintStream out = null;
        // out как раз представляет статическую константу класса System. Поэтому
        // обращение к ней идет без создания объекта класса System.
    }
}

class Math12 {
    public static final double PI = 3.14; // Статическая константа ч/з final

}
