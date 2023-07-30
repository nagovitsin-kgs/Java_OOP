package Seminar_05.study_group.presenter;

import Seminar_05.study_group.model.service.Service;
import Seminar_05.study_group.view.ConsoleUI;
import Seminar_05.study_group.view.View;

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

    public void addStudent(String name, int age) {
        service.addStudent(name, age);
        // какой-то ответ
        getStudentsListInfo();
    }

    public void getStudentsListInfo() {
        String info = service.getStudentsInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getStudentsListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getStudentsListInfo();
    }
}
