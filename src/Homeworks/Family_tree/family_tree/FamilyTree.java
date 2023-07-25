package Homeworks.family_tree.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Homeworks.family_tree.person.Human;

public class FamilyTree implements Serializable {
    private int humanId;
    private List<Human> peopleList;
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
     * @param people        - значение параметра people присваивается полю people
     * @param relationships - значение параметра relationships присваивается полю
     *                      relationships
     */
    public FamilyTree(List<Human> people, Map<Human, List<Human>> relationships) {
        this.peopleList = people;
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

    public boolean addPerson(Human person) {
        if (person == null) {
            return false;
        }
        if (!peopleList.contains(person)) {
            peopleList.add(person);
            person.setId(humanId++);

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

    public List<Human> getChildren(Human person) {

        return relationships.getOrDefault(person, new ArrayList<>());
    }

    public List<Human> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Human> people) {
        this.peopleList = people;
    }

    public Map<Human, List<Human>> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<Human, List<Human>> relationships) {
        this.relationships = relationships;
    }

    @Override
    public String toString() {
        return "FamilyTree [\npeople=" + peopleList + ", \nrelationships=" + relationships + "\n]";
    }
}
