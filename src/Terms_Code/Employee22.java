package Terms_Code;

// Наследование.
/**
 * Производный класс имеет доступ ко всем методам и полям базового класса (даже
 * если базовый класс находится в другом пакете) кроме тех, которые определены с
 * модификатором private. При этом производный класс также может добавлять свои
 * поля и методы.
 * 
 * В данном случае класс Employee22 добавляет поле company, которое хранит место
 * работы сотрудника, а также метод work.
 */

class Employee22 extends Person21 {

    String company;

    public Employee22(String name, String company) { // определяем экземпляр класса

        super(name); // super(name) - вызов конструктора базового класса Person21
        this.company = company; // значение параметра произ-го класса Employee22,
                                // которое присваевается полю (String company)
                                // произ-го класса Employee22
    }

    public void work() { // метод работа сотрудника
        System.out.printf("%s works in %s \n", getName(), company);
    }
}
