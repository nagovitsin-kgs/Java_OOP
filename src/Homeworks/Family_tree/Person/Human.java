package Homeworks.family_tree.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Экземпляр класса: public Human(String name, Gender gender, LocalDate
 * dateOfBirth, LocalDate
 * dateOfDeath)
 * 
 * Класс: public class Human implements Serializable, Comparable<Human>
 */

public class Human implements Serializable, Comparable<Human> {
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

    public Human(String name, LocalDate dateOfBirth) {
        this(name, null, dateOfBirth, null);
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

    // сгенерировал - переопределение метода toString для вывода
    @Override
    public String toString() {
        return "Human [id=" + id + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
                + ", dateOfDeath=" + dateOfDeath + "]";
    }

    // переопределение и реализация метода интерфейса Comparable для типа Human

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    // сгенирировался, пока не знаю зачем ???)
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    // сгенерировали и переопределили метод, чтобы соответствовать методу
    // сompareTo(Human o)
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

}
