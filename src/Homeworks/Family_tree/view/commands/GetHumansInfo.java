package Homeworks.family_tree.view.commands;

import Homeworks.family_tree.view.ConsoleUI;

public class GetHumansInfo extends Command {

    public GetHumansInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список людей";
    }

    public void execute() {
        consoleUI.getHumansInfo();
    }

    @Override
    public String toString() {
        return "GetHumansInfo []";
    }
}