package taxi777;

public class Program {
    public static void main(String[] args) {
        Person person = new Person();
        person.callTaxi(new Uber());

    }

}

interface Drivable { // интерфейс Управляемый
    void drive(String address); // метод водить машину(получает адрес)
    // обязаны реализовать метод во всех классах
    // Drivable dr = new Drivable(); - в проге не можем так!
}

class Friend implements Drivable { // класс Друг реализует интерфейс Управляемый
    @Override
    public void drive(String address) { // переопределение (описание) метода (обязательно) интерфейса Управляемый
        System.out.println("Поехали, дружище!");
    }
}

class Person { // класс Человек базовый класс.. Кол центр
    public void callTaxi(Drivable taxi) { // метод вызвать такси (обратились к типу интерфейса и реализовали метод)
        taxi.drive("Ленина, 55");
    }

}

abstract class Taxi implements Drivable { // абстрактный класс реализует интерфейс Управляемый
    // пустой
    // как и в интерфейсе методы, так и в астрактном коассе, мы обязаны реализовать
    // методы и класс
}

class Uber extends Taxi {
    @Override
    public void drive(String address) {
        System.out.println("убер такси привествует вас!");
    }
}

class Yandex extends Taxi {
    @Override
    public void drive(String address) {
        System.out.println("яндекс такси скоро приедет!");
    }
}
