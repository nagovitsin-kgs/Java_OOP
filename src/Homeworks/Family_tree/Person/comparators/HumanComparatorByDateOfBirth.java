package Homeworks.family_tree.person.comparators;

// import java.time.LocalDate;
import java.util.Comparator;

import Homeworks.family_tree.family_tree.FamilyTreeItemInter;
// import Homeworks.family_tree.person.Human;

public class HumanComparatorByDateOfBirth<T extends FamilyTreeItemInter> implements Comparator<T> {

    // @Override
    // public int compare(Human o1, Human o2) {
    // return compare(o1.getDateOfBirth(), o2.getDateOfBirth());

    // }

    // private int compare(LocalDate dateOfBirth, LocalDate dateOfBirth2) {
    // return compare(dateOfBirth, dateOfBirth2);
    // }
    @Override
    public int compare(T o1, T o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());

    }

}
