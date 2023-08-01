package Homeworks.family_tree.presenter;

import java.time.LocalDate;

import Homeworks.family_tree.model.person.Gender;
import Homeworks.family_tree.model.service.Service;
import Homeworks.family_tree.view.View;

/**
 * Связь с View и Service (Model)
 * т.е связь с видом и моделью
 * 
 * @param View      - вид или представление
 * @param Service   - модель
 * @param Presenter - представитель
 */
public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth) {
        service.addHuman(name, gender, dateOfBirth);
        // вывод информации
        getHumansInfo();
    }

    public void getHumansInfo() {
        String info = service.getHumansInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumansInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumansInfo();
    }

    public void sortByDateOfBirth() {
        service.sortByDateOfBirth();
        getHumansInfo();
    }

    @Override
    public String toString() {
        return "Presenter [view=" + view + ", service=" + service + "]";
    }
}
