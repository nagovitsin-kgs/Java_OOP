package Homeworks.family_tree.model.family_tree;

import java.time.LocalDate;

public interface FamilyTreeItemInter {

    String getName();

    LocalDate getDateOfBirth();

    void setId(int id);
}