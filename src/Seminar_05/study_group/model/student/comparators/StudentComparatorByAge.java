package Seminar_05.study_group.model.student.comparators;

import java.util.Comparator;

import Seminar_05.study_group.model.group.GroupItem;

public class StudentComparatorByAge<T extends GroupItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
