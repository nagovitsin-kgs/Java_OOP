package Homeworks.family_tree.service;

import Homeworks.family_tree.person.Human;
import java.time.LocalDate;
import Homeworks.family_tree.family_tree.FamilyTree;

public class Service {

    FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, LocalDate dateOfBirth) {
        Human human = new Human(name, dateOfBirth);
        familyTree.addHuman(human);
    }

    public String getHumansInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Люди:\n");
        // Iterator<Human> iterator = familyTree.iterator();
        // while (iterator.hasNext()){
        // Human human = iterator.next();
        // stringBuilder.append(human);
        // stringBuilder.append("\n");
        // }
        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByDateOfBirth() {
        familyTree.sortByDateOfBirth();
    }
}
