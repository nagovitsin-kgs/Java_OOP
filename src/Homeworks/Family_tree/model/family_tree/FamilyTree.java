package Homeworks.family_tree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// import Homeworks.family_tree.model.person.Human;
import Homeworks.family_tree.model.person.comparators.HumanComparatorByAge;
import Homeworks.family_tree.model.person.comparators.HumanComparatorByDateOfBirth;
import Homeworks.family_tree.model.person.comparators.HumanComparatorByName;

public class FamilyTree<E extends FamilyTreeItemInter> implements Serializable, Iterable<E> {
    private int humanId;
    private List<E> humanList;
    private Map<E, List<E>> relationships;

    /**
     * Можно только так:
     * public FamilyTree() {
     * this.humanList = new ArrayList<>();
     * this.relationships = new HashMap<>();
     * }
     * А лучше, наверно, так:
     */
    /**
     * Создание экземпляра класса, в котором:
     * 
     * @param human         - значение параметра human присваивается полю humanList
     * @param relationships - значение параметра relationships присваивается полю
     *                      relationships
     */

    public FamilyTree(List<E> human, Map<E, List<E>> relationships) {
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

    public List<E> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<E> human) {
        this.humanList = human;
    }

    public Map<E, List<E>> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<E, List<E>> relationships) {
        this.relationships = relationships;
    }

    public boolean addHuman(E human) {
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

    public boolean addParentChildRelationships(E parent, E child) {
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

    public List<E> getChildrenByName(E human) {
        List<E> children = relationships.getOrDefault(human, new ArrayList<>());
        System.out.println("Дети у родителя " + human.getName() + ":");
        for (E child : children) {
            System.out.println(child.getName() + "\n");
        }
        return children;
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }

    public void sortByDateOfBirth() {
        humanList.sort(new HumanComparatorByDateOfBirth<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

    // @Override
    // public String toString() {
    // return "FamilyTree [\nhumanList=" + humanList + ", \nrelationships=" +
    // relationships + "\n]";
    // }
    //
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
