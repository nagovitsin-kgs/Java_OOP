package Homeworks.family_tree.view;

import java.time.LocalDate;
import java.util.Scanner;
import Homeworks.family_tree.presenter.Presenter;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение"; // константа
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private ProgramMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new ProgramMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("До новых встреч");
        work = false;
    }

    public void sortByDateOfBirth() {
        presenter.sortByDateOfBirth();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumansInfo() {
        presenter.getHumansInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения человека: год-месяц-день");
        String dateOfBirthString = scanner.nextLine();
        // TODO сделать проверку ввода возраста
        // Загуглил вроде так можно
        // DateTimeFormatter inputDate = DateTimeFormatter.ofPattern("yy_dd_MM");
        // LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString, inputDate);
        // 16:06
        // String inputDate = "21_05_2023";
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
        presenter.addHuman(name, dateOfBirth);
    }

    private void hello() {
        System.out.println("Здравствуйте!");
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand < menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

}
