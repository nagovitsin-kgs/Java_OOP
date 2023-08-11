package Homeworks.dogs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Homeworks.family_tree.model.family_tree.FamilyTreeItemInter;
import Homeworks.family_tree.model.person.Gender;

public class Dog implements FamilyTreeItemInter<Dog> {
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
    public String toString() {

        return "Dog [id=" + id + ", name=" + name + ", gender=" + gender + ", dogList=" + dogList + "]";

    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public Dog getFather() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFather'");
    }

    @Override
    public Dog getMother() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMother'");
    }

    @Override
    public boolean addParent(Dog parent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addParent'");
    }

    @Override
    public boolean addChild(Dog child) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addChild'");
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public LocalDate getDateOfDeath() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDateOfDeath'");
    }

    @Override
    public LocalDate getDateOfBirth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDateOfBirth'");
    }

    @Override
    public List<Dog> getChildren() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChildren'");
    }

    @Override
    public List<Dog> getParents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getParents'");
    }

    @Override
    public Dog getSpouse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpouse'");
    }

    @Override
    public void setSpouse(Dog spouse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSpouse'");
    }

    @Override
    public int getAge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAge'");
    }

    @Override
    public void getFileHandler(String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFileHandler'");
    }

    @Override
    public void getFilePath(String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFilePath'");
    }

    @Override
    public boolean addParentChildRelationships(Dog parent, Dog child) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addParentChildRelationships'");
    }

}
