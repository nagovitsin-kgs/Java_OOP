package Seminar_05.study_group.model.student.comparators;

import java.util.Comparator;

import Seminar_05.study_group.model.group.GroupItem;

public class StudentComparatorByName<T extends GroupItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
