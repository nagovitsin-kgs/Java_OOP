package Terms_Code;

public class Program_21 {

    public static void main(String[] args) {

        Person21 kate = new Person21("Kate", 30); // конструктор, коллекция
        System.out.println(kate.getAge()); // 30
        kate.setAge(33);
        System.out.println(kate.getAge()); // 33
        kate.setAge(123450); // не изменил, потому что условие в setAge: age < 110
        System.out.println(kate.getAge()); // 33
        kate.setAge(85);
        System.out.println(kate.getAge()); // 85
        System.out.println(kate); // Terms_Code.21Person21@7a81197d, надо переопр-ть метод toString - он по умол
        // переопределим его в 21Person21
    }
}

class Person21 {

    private String name;
    private int age = 1;

    // сам переопределил:
    @Override
    public String toString() {
        return String.format("%s %d", name, age);
    }

    public Person21(String name, int age) {

        setName(name);
        setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 110)
            this.age = age;
    }

}
