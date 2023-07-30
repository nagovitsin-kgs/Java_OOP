package Seminar_05.study_group.model.group;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Seminar_05.study_group.model.group.iterators.StudentIterator;
import Seminar_05.study_group.model.student.comparators.StudentComparatorByAge;
import Seminar_05.study_group.model.student.comparators.StudentComparatorByName;

public class StudyGroup<E extends GroupItem> implements Iterable<E> {
    private List<E> studentList;

    public StudyGroup() {
        studentList = new ArrayList<>();
    }

    public void addStudent(E student){

        studentList.add(student);
    }

    @Override
    public Iterator<E> iterator() {
        return new StudentIterator<>(studentList);
    }

    public void sortByName(){
        studentList.sort(new StudentComparatorByName<>());
    }

    public void sortByAge(){
        studentList.sort(new StudentComparatorByAge<>());
    }
}
