package Homeworks.family_tree.view.commands;

import Homeworks.family_tree.view.ConsoleUI;

/**
 * Абстрактный класс Команда
 * 
 * @param description - описание
 * @param consoleUI   - пользовательский интерфейс UI
 */
public abstract class Command {
    String description;
    ConsoleUI consoleUI;

    // конструктор, экземпляр абстрактноего класса Команда
    protected Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    // метод получить описание
    public String getDescription() {
        return description;
    }

    // абстрактный метод выполнять
    public abstract void execute();
}