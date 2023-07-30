package Seminar_05.study_group.view.commands;

import Seminar_05.study_group.view.ConsoleUI;

public class AddStudent extends Command{

    public AddStudent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить студента";
    }

    public void execute(){
        consoleUI.addStudent();
    }
}
