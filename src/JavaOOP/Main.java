package JavaOOP;

public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина", 56);
        Person igor = new Person("Игорь", 60);
        Person vasya = new Person("Вася", 30);
        Person masha = new Person("Маша", 27);
        Person jane = new Person("Женя", 10);
        Person ivan = new Person("Ваня", 8);
        Person sasha = new Person("Саша", 9);
        Person sasha10 = new Person("Саша", 10);
        Person sasha11 = new Person("Саша", 11);
        Person sasha3 = new Person("Саша", 3);
        GeoTree gt = new GeoTree();
        gt.appendPerentChild(irina, vasya); // Ирина родитель Васи
        gt.appendPerentChild(irina, masha); // Ирина родитель Маши

        gt.appendPerentChild(vasya, jane); // Вася родитель Жени
        gt.appendPerentChild(vasya, ivan); // Вася родитель Ивана

        gt.appendVifeHusbent(irina, igor); // Ирина жена Игоря

        gt.appendPerentChild(igor, vasya); // Игорь родитель Васи
        gt.appendPerentChild(igor, masha); // Игорь родитель Маши
        gt.appendPerentChild(igor, sasha); // Игорь родитель Саши
        gt.appendPerentChild(igor, sasha10); // Игорь родитель Саши
        gt.appendPerentChild(igor, sasha11); // Игорь родитель Саши
        gt.appendPerentChild(igor, sasha3); // Игорь родитель Саши

        // Ищем детей Ирины
        System.out.println("Дети Ирины");
        System.out.println(new Research(gt).spend(irina, Relationship.parent)); // [Вася, Маша]
        // Ищем детей Игоря
        System.out.println("Дети Игоря");
        System.out.println(new Research(gt).spend(igor, Relationship.parent)); // [Вася, Маша, Саша, Саша, Саша, Саша]

        // Ищем мужа Ирины (Чья жена Ирина?)
        System.out.println("Муж Ирины");
        System.out.println(new Research(gt).spend(irina, Relationship.vife)); // [Игорь]

        // Ищем людей определенного возраста
        System.out.println(new Research(gt).searchAge());
    }
}