package Seminar_04_weather_api.main.java.presenter;

import Seminar_04_weather_api.main.java.ui.View;
import Seminar_04_weather_api.main.java.weather_api.Service;
import Seminar_04_weather_api.main.java.weather_api.WeatherService;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new WeatherService();
    }

    public void getInfo(String city) {
        String answer = service.get(city);
        view.print(answer);
    }
}
