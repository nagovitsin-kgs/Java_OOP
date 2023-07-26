package Homeworks.family_tree.person.comparators;

import java.time.LocalDate;
import java.util.Comparator;

import Homeworks.family_tree.person.Human;

public class HumanComparatorByDateOfBirth implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return compare(o1.getDateOfBirth(), o2.getDateOfBirth());

    }

    private int compare(LocalDate dateOfBirth, LocalDate dateOfBirth2) {
        return 0;
    }

}
