package Seminar_04.study_group.student.comparators;

import Seminar_04.study_group.group.GroupItem;
import Seminar_04.study_group.student.Student;

import java.util.Comparator;

public class StudentComparatorByName<E extends GroupItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
