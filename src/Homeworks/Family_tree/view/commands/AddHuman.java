package Homeworks.family_tree.view.commands;

import Homeworks.family_tree.view.ConsoleUI;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    public void execute() {
        consoleUI.addHuman();
    }

    @Override
    public String toString() {
        return "AddHuman []";
    }
}
