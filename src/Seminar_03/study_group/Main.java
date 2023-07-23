package study_group;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.addStudent("Саша", 18);
        service.addStudent("Даша", 19);
        service.addStudent("Маша", 21);
        service.addStudent("Паша", 20);

        System.out.println(service.getInfo());
        service.sortByName();
        System.out.println(service.getInfo());
        service.sortByAge();
        System.out.println(service.getInfo());
    }
}
