package com.company;

import java.util.Observer;
import java.util.Observable;

public class ForecastDisplay implements Observer, DisplayElement{

    public ForecastDisplay(Observable observable){
        if (observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData) observable;
        }
    }

    public void display() {

    }


    public void update(float temp, float humidity, float pressure) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
