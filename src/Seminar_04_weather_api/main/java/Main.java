package Seminar_04_weather_api.main.java;

import Seminar_04_weather_api.main.java.ui.ConsoleUI;
import Seminar_04_weather_api.main.java.ui.DesktopUI;
import Seminar_04_weather_api.main.java.ui.View;
import Seminar_04_weather_api.main.java.weather_api.Connection;

public class Main {
    public static void main(String[] args) {
        View view = new DesktopUI();
        view.start();
    }
}
