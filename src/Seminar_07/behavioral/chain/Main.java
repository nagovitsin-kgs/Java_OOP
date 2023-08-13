package Seminar_07.behavioral.chain;

public class Main {
    public static void main(String[] args) {
        Notifier simpleNotifier = new SimpleNotifier(1);
        Notifier emailNotifier = new EmailNotifier(2);
        Notifier smsNotifier = new SMSNotifier(3);

        simpleNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        simpleNotifier.manage("Все в порядке", 1);
        simpleNotifier.manage("Что-то пошло не так", 2);
        simpleNotifier.manage("Все плохо!", 3);
    }
}
