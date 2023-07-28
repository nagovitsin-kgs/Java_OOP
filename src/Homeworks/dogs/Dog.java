package Homeworks.dogs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Homeworks.family_tree.family_tree.FamilyTreeItemInter;
import Homeworks.family_tree.person.Gender;

public class Dog implements FamilyTreeItemInter {
    protected int id;
    protected String name;
    protected Gender gender;
    private List<Dog> dogList;

    public Dog() {
        dogList = new ArrayList<>();

    }

    public boolean addDog(Dog name) {
        if (!dogList.contains(name)) {
            dogList.add(name);
            return true;
        }
        return false;
    }

    public Dog(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public LocalDate getDateOfBirth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDateOfBirth'");
    }

    @Override
    public void setId(int id) {
        // TODO Auto-generated method stub
        this.id = id;
    }

    @Override
    public String toString() {

        return "Dog [id=" + id + ", name=" + name + ", gender=" + gender + ", dogList=" + dogList + "]";

    }

}
