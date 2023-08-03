package Homeworks.family_tree;

import java.time.LocalDate;

import Homeworks.dogs.Dog;
import Homeworks.family_tree.model.family_tree.FamilyTree;
import Homeworks.family_tree.model.person.Gender;
import Homeworks.family_tree.model.person.Human;
import Homeworks.family_tree.model.service.Service;
import Homeworks.family_tree.model.writer.FileHandler;
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
        Human bob = new Human("Боб", Gender.MALE, LocalDate.of(1989, 3, 5), john, jane);
        Human bobi = new Human("Боби", Gender.FEMALE, LocalDate.of(1991, 5, 10));
        Human alice = new Human("Алиса", Gender.FEMALE, LocalDate.of(2009, 1, 1), bob, bobi);
        Human mex = new Human("Мекс", Gender.MALE, LocalDate.of(2011, 4, 6), bob, bobi);
        Human lisa = new Human("Лиза", Gender.FEMALE, LocalDate.of(2012, 11, 23), bob, bobi);
        Human dic = new Human("Дик", Gender.FEMALE, LocalDate.of(2014, 9, 13), bob, bobi);

        // Добавление людей в генеалогическое древо
        familyTree.addHuman(john);
        familyTree.addHuman(jane);
        familyTree.addHuman(bob);
        familyTree.addHuman(bobi);
        familyTree.addHuman(alice);
        familyTree.addHuman(mex);
        familyTree.addHuman(lisa);
        familyTree.addHuman(dic);

        // Создание связей между людьми в генеалогическом древе
        familyTree.addParentChildRelationships(john, bob);
        // familyTree.addParentChildRelationships(jane, bob);
        // familyTree.addParentChildRelationships(bob, alice);
        // familyTree.addParentChildRelationships(bob, mex);
        // familyTree.addParentChildRelationships(bob, lisa);
        familyTree.addParentChildRelationships(bob, dic);
        // familyTree.addParentChildRelationships(bobi, alice);
        // familyTree.addParentChildRelationships(bobi, mex);
        // familyTree.addParentChildRelationships(bobi, lisa);
        // familyTree.addParentChildRelationships(bobi, dic);
        System.out.println(familyTree);
        // Получение всех детей выбранного человека
        familyTree.getChildrenByName(bob);

        // List<Human> children = familyTree.getChildren(bob);
        // System.out.println("Дети " + bob.getName() + "а" + ":"); // Дети Боба:
        // for (Human child : children) {
        // System.out.println(child.getName() + "\n"); // Алиса
        // }
        // System.out.println(familyTree); // сделал переопределения метода toString
        // в классах

        System.out.println("\nЗадание к уроку 2:________________________________\n");

        // Создание пути или обращение к уже созанному файлу
        String filePath = "src/Homeworks/family_tree/model/files/familyTree.out";

        // Создали конструкто класса, который implements интерфейсы WritingFile,
        // ReadingFile
        FileHandler fileHandler = new FileHandler();

        // Сохранение и создания файла с помощью методов интерфейсов и серилизации
        fileHandler.createSaveWriteFile(familyTree, filePath); // запись и сохранение
        // файла, создание
        // System.out.println(familyTree + "\n");

        // FileProcessing fileProcessing = new FileProcessing();

        // Чтение файла
        familyTree = (FamilyTree<Human>) fileHandler.readFile(filePath);
        // System.out.println(familyTree + "\n");

        System.out.println("\nЗадание к уроку 3:________________________________\n");

        // Создание конструктора для добавления людей в древо
        Service service = new Service();

        service.addHuman("Гоша", Gender.MALE, LocalDate.of(1984, 05, 10));
        service.addHuman("Петя", Gender.MALE, LocalDate.of(1975, 12, 06));
        service.addHuman("Кристина", Gender.FEMALE, LocalDate.of(1965, 07, 22));
        service.addHuman("Кирилл", Gender.MALE, LocalDate.of(2001, 02, 25));

        // Вывод информации по людям до сортировки:
        System.out.println(service.getHumansInfo());

        // сортировка в древе по имени добавленных людей
        service.sortByName();

        // Вывод информации по людям после сортировки по имени:
        System.out.println(service.getHumansInfo());

        // сортировка в древе по дате рождения добавленных людей
        service.sortByAge();

        // Вывод информации по людям после сортировки по дате рождения:
        System.out.println(service.getHumansInfo());

        System.out.println("\nЗадание к уроку 4:________________________________\n");

        // добавление в древо собак)
        FamilyTree<Dog> tree = new FamilyTree<>();
        tree.addHuman(new Dog("Доллар", Gender.MALE));
        tree.addHuman(new Dog("Найда", Gender.FEMALE));
        System.out.println(tree);

        System.out.println("\nЗадание к уроку 5:________________________________\n");

        // создание
        View view = new ConsoleUI();
        view.start();

        System.out.println("\nЗадание к уроку 6:________________________________\n");
    }

}
