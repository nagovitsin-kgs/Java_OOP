package Homeworks.family_tree.model.person.comparators;

import java.util.Comparator;

import Homeworks.family_tree.model.family_tree.FamilyTreeItemInter;

public class HumanComparatorByName<T extends FamilyTreeItemInter<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {

        return o1.getName().compareTo(o2.getName());
    }

}
