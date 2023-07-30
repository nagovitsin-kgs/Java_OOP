package Seminar_05.study_group.view.commands;

import Seminar_05.study_group.view.ConsoleUI;

public class GetStudentsInfo extends Command {
    public GetStudentsInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список студентов";
    }

    public void execute(){
        consoleUI.getStudentsListInfo();
    }
}
