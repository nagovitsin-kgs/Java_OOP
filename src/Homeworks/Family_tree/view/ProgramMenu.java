package Homeworks.family_tree.view;

import java.util.ArrayList;
import java.util.List;

import Homeworks.family_tree.view.commands.AddHuman;
import Homeworks.family_tree.view.commands.Command;
import Homeworks.family_tree.view.commands.Finish;
import Homeworks.family_tree.view.commands.GetHumansInfo;
import Homeworks.family_tree.view.commands.SortByDateOfBirth;
import Homeworks.family_tree.view.commands.SortByName;

public class ProgramMenu {

    private List<Command> commandList;

    public ProgramMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetHumansInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByDateOfBirth(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }

    @Override
    public String toString() {
        return "ProgramMenu [commandList=" + commandList + "]";
    }
}
