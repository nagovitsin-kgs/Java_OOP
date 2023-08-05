package Homeworks.family_tree.model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItemInter<T> {
    // T обобщение, ниже методы всё для людей
    void setId(int id);

    int getId();

    T getFather();

    T getMother();

    boolean addParent(T parent);

    boolean addChild(T child);

    String getName();

    LocalDate getDateOfDeath();

    LocalDate getDateOfBirth();

    List<T> getChildren();

    List<T> getParents();

    T getSpouse();

    void setSpouse(T spouse);

    int getAge();

}
