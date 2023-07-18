package Terms_Code;

// Абстрактные классы и методы.
/**
 * Другим хрестоматийным примером является система геометрических фигур.
 * В реальности не существует геометрической фигуры как таковой.
 * Есть круг, прямоугольник, квадрат, но просто фигуры нет.
 * Однако же и круг, и прямоугольник имеют что-то общее и являются фигурами.
 * 
 * Моё высказывание:
 * Поэтому тоже можно сделать класс фигуры - абстрктным, а в производных
 * классах, наследниках фигуры - реализовать и переопределить абстрактные
 * методы, так как в программе создать объект и конструктор абстрактного
 * базового класса нельзя!
 */

public class Program_28 {
    public static void main(String[] args) {

        Rectangle rect = new Rectangle(1, 2, 10, 10);

        System.out.println(rect.getPerimeter()); // 40.0
        System.out.println(rect.getArea()); // 100.0

        System.out.println(rect.getClass()); // class Terms_Code.Rectangle
        System.out.println(rect.x); // 1
        System.out.println(rect.y); // 2
        System.out.println(rect.equals(rect)); // true
        System.out.println(rect.hashCode()); // 617901222
        System.out.println(rect.toString()); // Terms_Code.Rectangle@24d46ca6

    }
}

// абстрактный класс фигуры
abstract class Figure {

    float x; // x-координата точки
    float y; // y-координата точки

    Figure(float x, float y) {

        this.x = x;
        this.y = y;
    }

    // абстрактный метод для получения периметра
    public abstract float getPerimeter();

    // абстрактный метод для получения площади
    public abstract float getArea();
}

// производный класс прямоугольника
class Rectangle extends Figure {
    private float width;
    private float height;

    // конструктор с обращением к конструктору класса Figure
    Rectangle(float x, float y, float width, float height) {

        super(x, y);
        this.width = width;
        this.height = height;
    }

    public float getPerimeter() {

        return width * 2 + height * 2;
    }

    public float getArea() {

        return width * height;
    }
}
