package Homeworks.family_tree.model.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Homeworks.family_tree.model.family_tree.FamilyTree;
import Homeworks.family_tree.model.family_tree.FamilyTreeItemInter;
import Homeworks.family_tree.model.writer.FileHandler;

/**
 * Экземпляр класса: public Human(String name, Gender gender, LocalDate
 * dateOfBirth, LocalDate
 * dateOfDeath)
 * 
 * Класс: public class Human implements Serializable, Comparable<Human>
 */

public class Human implements Serializable, Comparable<Human>, FamilyTreeItemInter<Human> {
    // Создание полей в классе
    private int id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    /**
     * Это экземпляр класса, в котором:
     * Ключевое слово this представляет ссылку на текущий экземпляр класса.
     * Через this мы можем обращаться к переменным, методам объекта, а также
     * вызывать его конструкторы.
     * 
     * @param name        - значение параметра name присваивается полю name
     * @param gender      - значение параметра name присваивается полю gender
     * @param dateOfBirth - значение параметра name присваивается полю dateOfBirth
     * @param dateOfDeath - значение параметра name присваивается полю dateOfDeath
     */
    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth) {
        this(name, gender, dateOfBirth, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, Human father, Human mother) {
        this(name, gender, dateOfBirth, null, father, mother);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public int getAge() {
        if (dateOfDeath == null) {
            return getPeriod(dateOfBirth, LocalDate.now());
        } else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period difference = Period.between(dateOfBirth, dateOfDeath);
        return difference.getYears();
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.MALE) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.FEMALE) {
                return parent;
            }
        }
        return null;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getSpouseInfo() {
        String result = "супруг(а): ";
        if (spouse == null) {
            result += "нет";
        } else {
            result += spouse.getName();
        }
        return result;
    }

    public String getMotherInfo() {
        String result = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            result += mother.getName();
        } else {
            result += "неизвестна";
        }
        return result;
    }

    public String getFatherInfo() {
        String result = "отец: ";
        Human father = getFather();
        if (father != null) {
            result += father.getName();
        } else {
            result += "неизвестен";
        }
        return result;
    }

    public String getChildrenInfo() {
        StringBuilder result = new StringBuilder();
        result.append("дети: ");
        if (!children.isEmpty()) {
            result.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                result.append(", ");
                result.append(children.get(i).getName());
            }
        } else {
            result.append("отсутствуют");
        }
        return result.toString();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nid: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", дата рождения: ");
        sb.append(getDateOfBirth());
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    // переопределение и реализация метода интерфейса Comparable для типа Human
    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    @Override
    public void getFileHandler(String filePath) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        List<Human> humanList = new ArrayList<>();
        for (Human human : humanList) {
            familyTree.addHuman(human);
        }
        // String filePath = "src/Homeworks/family_tree/model/files/familyTree.out";
        FileHandler fileHandler = new FileHandler();
        fileHandler.createSaveWriteFile(familyTree, filePath);
    }

    @Override
    public void getFilePath(String filePath) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        List<Human> humanList = new ArrayList<>();
        for (Human human : humanList) {
            familyTree.addHuman(human);
        }
        // String filePath = "src/Homeworks/family_tree/model/files/familyTree.out";
        FileHandler fileHandler = new FileHandler();
        familyTree = (FamilyTree<Human>) fileHandler.readFile(filePath);
        System.out.println(familyTree);
    }

    @Override
    public boolean addParentChildRelationships(Human parent, Human child) {
        Map<Human, List<Human>> relationships = new HashMap<>();

        if (parent == null) {
            return false;
        }
        if (!relationships.containsKey(parent)) {
            relationships.put(parent, new ArrayList<>());
            relationships.get(parent).add(child);

            return true;
        }
        return false;
    }

}
