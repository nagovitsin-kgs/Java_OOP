package Homeworks.family_tree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Homeworks.family_tree.model.person.Human;
// import Homeworks.family_tree.model.person.Human;
import Homeworks.family_tree.model.person.comparators.HumanComparatorByAge;
import Homeworks.family_tree.model.person.comparators.HumanComparatorByDateOfBirth;
import Homeworks.family_tree.model.person.comparators.HumanComparatorByName;
import Homeworks.family_tree.model.writer.FileHandler;

public class FamilyTree<E extends FamilyTreeItemInter<E>> implements Serializable, Iterable<E> {
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

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    // for (Map.Entry<String,String> : map.entrySet())

    // 16:53
    // for (Map.Entry<String,String> entry : map.entrySet())

    // 16:54
    // for (String key : map.keySet())

    // 16:56
    // sb.append(map.getValue(key))

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
            System.out.println(child.getName());

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

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В familyTree: ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human : humanList) {
            sb.append(human);
            // sb.append("");
        }

        return sb.toString();

    }

    @Override
    public String toString() {
        return getInfo();
    }

    // @Override
    // public String toString() {
    // return "FamilyTree [humanId=" + humanId + ", humanList=" + humanList +
    // ",\nrelationships=" + relationships
    // + "]";
    // }

}
