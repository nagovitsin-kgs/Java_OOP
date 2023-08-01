package Homeworks.family_tree.view.commands;

import Homeworks.family_tree.view.ConsoleUI;

public class SortByDateOfBirth extends Command {

    public SortByDateOfBirth(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по дате рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortByDateOfBirth();
    }

}
