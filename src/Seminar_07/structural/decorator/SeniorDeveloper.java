package Seminar_07.structural.decorator;

public class SeniorDeveloper extends DeveloperDecorator {
    public SeniorDeveloper(Developer developer) {
        super(developer);
    }

    String makeReview(){
        return "Делаю проверку кода.";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + " " + makeReview();
    }
}
