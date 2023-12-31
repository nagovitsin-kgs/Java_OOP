package Homeworks.family_tree.model.service;

import Homeworks.family_tree.model.family_tree.FamilyTree;
import Homeworks.family_tree.model.person.Gender;
import Homeworks.family_tree.model.person.Human;

import java.time.LocalDate;

public class Service {

    FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth) {
        Human human = new Human(name, gender, dateOfBirth);
        familyTree.addHuman(human);
    }

    public String getHumansInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В Service объекты: \n");
        for (Human human : familyTree) {
            sb.append(human);
            // sb.append("\n");
        }
        sb.append("\n");
        // Либо так:
        // Iterator<Human> iterator = familyTree.iterator();
        // while (iterator.hasNext()){
        // Human human = iterator.next();
        // sb.append(human);
        // sb.append("\n");
        // }

        return sb.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByDateOfBirth() {
        familyTree.sortByDateOfBirth();
    }

    // @Override
    // public String toString() {
    // return getHumansInfo();
    // }

}
