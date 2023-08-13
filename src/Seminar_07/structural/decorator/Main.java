package Seminar_07.structural.decorator;

public class Main {
    public static void main(String[] args) {
        Developer developer = new SeniorDeveloper(new SigleDeveloper());

        System.out.println(developer.makeJob());
    }
}
