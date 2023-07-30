package Homeworks.family_tree;

import java.time.LocalDate;
import java.util.*;

import Homeworks.dogs.Dog;
import Homeworks.family_tree.model.family_tree.FamilyTree;
import Homeworks.family_tree.model.person.Gender;
import Homeworks.family_tree.model.person.Human;
import Homeworks.family_tree.model.service.Service;
import Homeworks.family_tree.model.writer.FileProcessing;
import Homeworks.family_tree.view.ConsoleUI;
import Homeworks.family_tree.view.View;

public class Program {
    public static void main(String[] args) {
        System.out.println("\nЗадание к уроку 1:________________________________\n");

        // Создание генеалогического древа
        FamilyTree<Human> familyTree = new FamilyTree<>();

        // Создание людей для добавления в генеалогическое древо
        Human john = new Human("Джон", Gender.MALE, LocalDate.of(1974, 7, 10));
        Human jane = new Human("Джейн", Gender.FEMALE, LocalDate.of(1979, 6, 12));
        Human bob = new Human("Боб", Gender.MALE, LocalDate.of(1989, 3, 5));
        Human alice = new Human("Алиса", Gender.FEMALE, LocalDate.of(2001, 1, 1));

        // Добавление людей в генеалогическое древо
        familyTree.addHuman(john);
        familyTree.addHuman(jane);
        familyTree.addHuman(bob);
        familyTree.addHuman(alice);

        // Создание связей между людьми в генеалогическом древе
        familyTree.addParentChildRelationships(john, bob);
        familyTree.addParentChildRelationships(jane, bob);
        familyTree.addParentChildRelationships(bob, alice);

        // Получение всех детей выбранного человека
        List<Human> children = familyTree.getChildren(bob);
        System.out.println("Дети " + bob.getName() + "а" + ":"); // Дети Боба:
        for (Human child : children) {
            System.out.println(child.getName() + "\n"); // Алиса
        }
        System.out.println(familyTree); // сделал переопределения метода toString в классах

        System.out.println("\nЗадание к уроку 2:________________________________\n");

        // Создание пути или обращение к уже созанному файлу
        String filePath = "src/Homeworks/family_tree/files/familyTree.out";

        // Создали конструкто класса, который implements интерфейсы WritingFile,
        // ReadingFile
        FileProcessing fileProcessing = new FileProcessing();

        // Сохранение и создания файла с помощью методов интерфейсов и серилизации
        fileProcessing.createSaveWriteFile(familyTree, filePath); // запись и сохранение файла, создание
        System.out.println(familyTree + "\n");

        // FileProcessing fileProcessing = new FileProcessing();

        // Чтение файла
        familyTree = (FamilyTree<Human>) fileProcessing.readFile(filePath);
        System.out.println(familyTree + "\n");

        // Создание конструктора для добавления людей в древо
        Service service = new Service();

        service.addHuman("Гоша", LocalDate.of(1984, 05, 10));
        service.addHuman("Петя", LocalDate.of(1975, 12, 06));
        service.addHuman("Кристина", LocalDate.of(1965, 07, 22));
        service.addHuman("Кирилл", LocalDate.of(2001, 02, 25));

        // Вывод информации по людям до сортировки:
        System.out.println(service.getHumansInfo());
        /**
         * Люди:
         * Human [id=0, name=Гоша, gender=null, dateOfBirth=1984-05-10,
         * dateOfDeath=null]
         * Human [id=1, name=Петя, gender=null, dateOfBirth=1975-12-06,
         * dateOfDeath=null]
         * Human [id=2, name=Кристина, gender=null, dateOfBirth=1965-07-22,
         * dateOfDeath=null]
         * Human [id=3, name=Кирилл, gender=null, dateOfBirth=2001-02-25,
         * dateOfDeath=null]
         */

        // сортировка в древе по имени добавленных людей
        service.sortByName();

        // Вывод информации по людям после сортировки по имени:
        System.out.println(service.getHumansInfo());
        /**
         * Люди:
         * Human [id=0, name=Гоша, gender=null, dateOfBirth=1984-05-10,
         * dateOfDeath=null]
         * Human [id=3, name=Кирилл, gender=null, dateOfBirth=2001-02-25,
         * dateOfDeath=null]
         * Human [id=2, name=Кристина, gender=null, dateOfBirth=1965-07-22,
         * dateOfDeath=null]
         * Human [id=1, name=Петя, gender=null, dateOfBirth=1975-12-06,
         * dateOfDeath=null]
         */

        // сортировка в древе по дате рождения добавленных людей
        service.sortByDateOfBirth();

        // Вывод информации по людям после сортировки по дате рождения:
        System.out.println(service.getHumansInfo());
        /**
         * Люди:
         * Human [id=2, name=Кристина, gender=null, dateOfBirth=1965-07-22,
         * dateOfDeath=null]
         * Human [id=1, name=Петя, gender=null, dateOfBirth=1975-12-06,
         * dateOfDeath=null]
         * Human [id=0, name=Гоша, gender=null, dateOfBirth=1984-05-10,
         * dateOfDeath=null]
         * Human [id=3, name=Кирилл, gender=null, dateOfBirth=2001-02-25,
         * dateOfDeath=null]
         */

        // добавление в древо собак)
        FamilyTree<Dog> tree = new FamilyTree<>();
        tree.addHuman(new Dog("Доллар", Gender.MALE));
        tree.addHuman(new Dog("Найда", Gender.FEMALE));
        System.out.println(tree);

        // создание
        View view = new ConsoleUI();
        view.start();

    }

}