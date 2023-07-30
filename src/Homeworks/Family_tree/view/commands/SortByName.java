package Homeworks.family_tree.view.commands;

import Homeworks.family_tree.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по имени";
    }

    public void execute() {
        consoleUI.sortByName();
    }
}
