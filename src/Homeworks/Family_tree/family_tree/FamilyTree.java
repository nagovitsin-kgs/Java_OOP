package Homeworks.family_tree.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Homeworks.family_tree.person.Human;
import Homeworks.family_tree.person.comparators.HumanComparatorByDateOfBirth;
import Homeworks.family_tree.person.comparators.HumanComparatorByName;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int humanId;
    private List<Human> humanList;
    private Map<Human, List<Human>> relationships;

    // Можно только так:
    // public FamilyTree() {
    // this.people = new ArrayList<>();
    // this.relationships = new HashMap<>();
    // }
    // А лучше, наверно, так:
    /**
     * Создание экземпляра класса, в котором:
     * 
     * @param human         - значение параметра people присваивается полю people
     * @param relationships - значение параметра relationships присваивается полю
     *                      relationships
     */
    public FamilyTree(List<Human> human, Map<Human, List<Human>> relationships) {
        this.humanList = human;
        this.relationships = relationships;
    }

    /**
     * Создание экземпляра класса, в котором мы обращаемся к конструктору или
     * экземпляру класса и присваиваем в значение пустой конструктор (две коллекции)
     */
    public FamilyTree() {
        this(new ArrayList<>(), new HashMap<>());
    }

    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);

            return true;
        }
        return false;
    }

    public boolean addParentChildRelationships(Human parent, Human child) {
        if (parent == null) {

            return false;
        }
        if (!relationships.containsKey(parent)) {
            relationships.put(parent, new ArrayList<>());
            relationships.get(parent).add(child);
            return true;
        }
        return false;
    }

    public List<Human> getChildren(Human human) {

        return relationships.getOrDefault(human, new ArrayList<>());
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> human) {
        this.humanList = human;
    }

    public Map<Human, List<Human>> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<Human, List<Human>> relationships) {
        this.relationships = relationships;
    }

    @Override
    public String toString() {
        return "FamilyTree [\npeople=" + humanList + ", \nrelationships=" + relationships + "\n]";
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByDateOfBirth() {
        humanList.sort(new HumanComparatorByDateOfBirth());
    }

}
