package Homeworks.family_tree.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate
 * dateOfDeath)
 */
public class Human implements Serializable {
    // Создание полей в классе
    private int id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> parents;

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
    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth) {
        this(name, gender, dateOfBirth, null);
    }

    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public List<Human> getPerens() {
        return parents;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Human [id=" + id + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
                + ", dateOfDeath=" + dateOfDeath + "]";
    }

}
