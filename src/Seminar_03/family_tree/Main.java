package Seminar_03.family_tree;

import Seminar_03.family_tree.family_tree.FamilyTree;
import Seminar_03.family_tree.human.Gender;
import Seminar_03.family_tree.human.Human;
import Seminar_03.family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/Seminar_03/family_tree/data/tree.out";
        // Сохрани в файл, если нет создай, если есть, то не используем, а читаем файл!
        // FileHandler fileHandler = new FileHandler();
        // FamilyTree tree = testTree();
        // System.out.println(tree);

        // fileHandler.save(tree, filePath);

        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        System.out.println(tree);
    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.MALE, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Мария", Gender.FEMALE, LocalDate.of(1965, 9, 15));
        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya.getId(), masha.getId());

        Human christina = new Human("Кристина", Gender.FEMALE, LocalDate.of(1988, 7, 5),
                vasya, masha);
        Human semyon = new Human("Семен", Gender.MALE, LocalDate.of(1991, 1, 25),
                vasya, masha);
        tree.add(christina);
        tree.add(semyon);

        Human larisa = new Human("Лариса", Gender.FEMALE, LocalDate.of(1945, 9, 1));
        larisa.addChild(vasya);
        tree.add(larisa);

        return tree;
    }
}
