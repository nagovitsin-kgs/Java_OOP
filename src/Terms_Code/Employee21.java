package Terms_Code;

// Наследование.
/**
 * И, возможно, впоследствии мы захотим добавить еще один класс, который
 * описывает сотрудника предприятия - класс Employee21. Так как этот класс
 * реализует тот же функционал, что и класс Person21, поскольку сотрудник - это
 * также и человек, то было бы рационально сделать класс Employee21 производным
 * (наследником, подклассом) от класса Person21, который, в свою очередь,
 * называется базовым классом, родителем или суперклассом.
 * 
 * Чтобы объявить один класс наследником от другого, надо использовать после
 * имени класса-наследника ключевое слово extends, после которого идет имя
 * базового класса. Для класса Employee21 базовым является Person21, и поэтому
 * класс Employee21 наследует все те же поля и методы, которые есть в классе
 * Person21.
 * 
 * Если в базовом классе определены конструкторы, то в конструкторе производного
 * классы необходимо вызвать один из конструкторов базового класса с помощью
 * ключевого слова super. Например, класс Person21 имеет конструктор, который
 * принимает один параметр. Поэтому в классе Employee21 в конструкторе нужно
 * вызвать конструктор класса Person21. То есть вызов super(name) будет
 * представлять вызов конструктора класса Person21.
 * 
 * При вызове конструктора после слова super в скобках идет перечисление
 * передаваемых аргументов. При этом вызов конструктора базового класса должен
 * идти в самом начале в конструкторе производного класса. Таким образом,
 * установка имени сотрудника делегируется конструктору базового класса.
 * 
 * Причем даже если производный класс никакой другой работы не производит в
 * конструкторе, как в примере ниже, все равно необходимо вызвать конструктор
 * базового класса.
 */

public class Employee21 extends Person21 {

    public Employee21(String name) {
        super(name); // если базовый класс определяет конструктор
                     // то производный класс должен его вызвать
    }
}
