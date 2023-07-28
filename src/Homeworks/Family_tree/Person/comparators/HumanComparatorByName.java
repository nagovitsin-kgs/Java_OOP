package Homeworks.family_tree.person.comparators;

import java.util.Comparator;

import Homeworks.family_tree.family_tree.FamilyTreeItemInter;
// import Homeworks.family_tree.person.Human;

public class HumanComparatorByName<T extends FamilyTreeItemInter> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {

        return o1.getName().compareTo(o2.getName());
    }

}
