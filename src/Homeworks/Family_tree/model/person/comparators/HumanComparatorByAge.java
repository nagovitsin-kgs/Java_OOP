package Homeworks.family_tree.model.person.comparators;

import java.util.Comparator;

import Homeworks.family_tree.model.family_tree.FamilyTreeItemInter;

public class HumanComparatorByAge<T extends FamilyTreeItemInter> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
