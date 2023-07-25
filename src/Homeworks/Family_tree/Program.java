package Homeworks.family_tree;

import java.time.LocalDate;
import java.util.*;

import Homeworks.family_tree.data_fixation.FileProcessing;
import Homeworks.family_tree.family_tree.FamilyTree;
import Homeworks.family_tree.person.Gender;
import Homeworks.family_tree.person.Human;

public class Program {
    public static void main(String[] args) {
        System.out.println("\nЗадание к уроку 1:________________________________\n");

        // Создание генеалогического древа
        FamilyTree familyTree = new FamilyTree();

        // Создание людей для добавления в генеалогическое древо
        Human john = new Human("Джон", Gender.MALE, LocalDate.of(1974, 7, 10));
        Human jane = new Human("Джейн", Gender.FEMALE, LocalDate.of(1979, 6, 12));
        Human bob = new Human("Боб", Gender.MALE, LocalDate.of(1989, 3, 5));
        Human alice = new Human("Алиса", Gender.FEMALE, LocalDate.of(2001, 1, 1));

        // Добавление людей в генеалогическое древо
        familyTree.addPerson(john);
        familyTree.addPerson(jane);
        familyTree.addPerson(bob);
        familyTree.addPerson(alice);

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
        familyTree = (FamilyTree) fileProcessing.readFile(filePath);
        System.out.println(familyTree + "\n");
    }

}