package Serialazable;

// Сериализация в Java. Не все так просто!

import java.io.*;
// import java.io.Serializable;

/**
 * Сериализация (Serialization) — это процесс, который переводит объект в
 * последовательность байтов, по которой затем его можно полностью восстановить.
 * Зачем это нужно? Дело в том, при обычном выполнении программы максимальный
 * срок жизни любого объекта известен — от запуска программы до ее окончания.
 * Сериализация позволяет расширить эти рамки и «дать жизнь» объекту так же
 * между запусками программы.
 * 
 * Дополнительным бонусом ко всему является сохранение кроссплатформенности. Не
 * важно какая у вас операционная система, сериализация переводит объект в поток
 * байтов, который может быть восстановлен на любой ОС. Если вам необходимо
 * передать объект по сети, вы можете сериализовать объект, сохранить его в файл
 * и передать по сети получателю. Он сможет восстановить полученный объект. Так
 * же сериализация позволяет осуществлять удаленный вызов методов (Java RMI),
 * которые находятся на разных машинах с, возможно, разными операционными
 * системами, и работать с ними так, словно они находятся на машине вызывающего
 * java-процесса.
 * 
 * Реализовать механизм сериализации довольно просто. Необходимо, чтобы ваш
 * класс реализовывал интерфейс Serializable. Это интерфейс — идентификатор,
 * который не имеет методов, но он указывает jvm, что объекты этого класса могут
 * быть сериализованы. Так как механизм сериализации связан с базовой системой
 * ввода/вывода и переводит объект в поток байтов, для его выполнения необходимо
 * создать выходной поток OutputStream, упаковать его в ObjectOutputStream и
 * вызвать метод writeObject(). Для восстановления объекта нужно упаковать
 * InputStream в ObjectInputStream и вызвать метод readObject().
 * 
 * В процессе сериализации вместе с сериализуемым объектом сохраняется его граф
 * объектов. Т.е. все связанные с этим объекто, объекты других классов так же
 * будут сериализованы вместе с ним.
 * 
 * Рассмотри пример сериализации объекта класса Person.
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Home home = new Home("Vishnevaia 1");
        Person igor = new Person("Igor", 2, "Raphael", home);
        Person renat = new Person("Renat", 2, "Raphael", home);

        // Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(igor);
        objectOutputStream.writeObject(renat);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        Person igorRestored = (Person) objectInputStream.readObject();
        Person renatRestored = (Person) objectInputStream.readObject();
        objectInputStream.close();

        // Сериализация с помощью класса ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream2.writeObject(igor);
        objectOutputStream2.writeObject(renat);
        objectOutputStream2.flush();

        // Восстановление с помощью класса ByteArrayInputStream
        ObjectInputStream objectInputStream2 = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Person igorRestoredFromByte = (Person) objectInputStream2.readObject();
        Person renatRestoredFromByte = (Person) objectInputStream2.readObject();
        objectInputStream2.close();

        System.out.println("Before Serialize: " + "\n" + igor + "\n" + renat);
        System.out.println("After Restored From Byte: " + "\n" + igorRestoredFromByte + "\n" + renatRestoredFromByte);
        System.out.println("After Restored: " + "\n" + igorRestored + "\n" + renatRestored);

    }
}

/**
 * Вывод:
 * 
 * Before Serialize:
 * Person{name='Igor', countOfNiva=2, fatherName='Raphael', home=Home@355da254}
 * Person{name='Renat', countOfNiva=2, fatherName='Raphael', home=Home@355da254}
 * After Restored From Byte:
 * Person{name='Igor', countOfNiva=2, fatherName='Raphael', home=Home@27973e9b}
 * Person{name='Renat', countOfNiva=2, fatherName='Raphael', home=Home@27973e9b}
 * After Restored:
 * Person{name='Igor', countOfNiva=2, fatherName='Raphael', home=Home@312b1dae}
 * Person{name='Renat', countOfNiva=2, fatherName='Raphael', home=Home@312b1dae}
 * 
 * В данном примере класс Home создан для того чтобы продемонстрировать, что при
 * сериализации объекта Person, с ним сериализуется и граф его объектов. Класс
 * Home так же должен реализовывать интерфейс Serializable, иначе случится
 * исключение java.io.NotSerializableException. Так же в примере описана
 * сериализация с помощью класса ByteArrayOutputStream.
 * 
 * Из результатов выполнения программы можно сделать интересный вывод: при
 * восстановлении объектов, у которых до сериализации была ссылка на один и тот
 * же объект, этот объект будет восстановлен только один раз. Это видно по
 * одинаковым ссылкам в объектах после восстановления:
 * 
 * After Restored From Byte:
 * Person{name='Igor', countOfNiva=2, fatherName='Raphael', home=Home@27973e9b}
 * Person{name='Renat', countOfNiva=2, fatherName='Raphael', home=Home@27973e9b}
 * After Restored:
 * Person{name='Igor', countOfNiva=2, fatherName='Raphael', home=Home@312b1dae}
 * Person{name='Renat', countOfNiva=2, fatherName='Raphael', home=Home@312b1dae}
 * 
 * Однако, так же видно, что при выполнении записи двумя потоками вывода (у нас
 * это ObjectInputStream и ByteArrayOutputStream), объект home будет создан
 * заново, несмотря на то, что он уже был создан до этого в одном из потоков. Мы
 * видим это по разным адресам объектов home, полученных в двух потоках.
 * Получается, что если выполнить сериализацию одним выходным поток, затем
 * восстановить объект, то у нас есть гарантия восстановления полной сети
 * объектов без лишних дубликатов. Конечно, в ходе выполнения программы
 * состояние объектов может измениться, но это на совести программиста.
 * 
 * Проблема
 * 
 * Из примера так же видно, что при восстановлении объекта может возникнуть
 * исключение ClassNotFoundException. С чем это связано? Дело в том, что мы
 * легко можем сериализовать объект класса Person в файл, передать его по сети
 * нашему товарищу, который может восстановить объект другим приложением, в
 * котором класса Person попросту нет.
 * 
 */

class Home implements Serializable {
    private String home;

    public Home(String home) {
        this.home = home;
    }

    public String getHome() {
        return home;
    }
}

class Person implements Serializable {
    private String name;
    private int countOfNiva;
    private String fatherName;
    private Home home;

    public Person(String name, int countOfNiva, String fatherName, Home home) {
        this.name = name;
        this.countOfNiva = countOfNiva;
        this.fatherName = fatherName;
        this.home = home;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", countOfNiva=" + countOfNiva +
                ", fatherName='" + fatherName + '\'' +
                ", home=" + home +
                '}';
    }
}