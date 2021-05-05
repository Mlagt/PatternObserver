package com.company;

import java.util.Observable;
import java.util.Observer;

public class StatisticDisplay implements Observer, DisplayElement{
Observable observable;
    float sumTemp, sumHum, sumPress;
    float minTemp, minHum, minPress;
    float maxTemp, maxHum, maxPress;
    int counter = 0;
    

    public StatisticDisplay(Observable observable){
        this.observable = observable;
        this.observable.addObserver(this);
    }

    public void display() {
        System.out.println("Max temp = " + maxTemp + " average temp = " + sumTemp/counter);
    }

    @Override
    public void update(Observable o, Object arg) {
        WeatherData weatherData = (WeatherData) o; 
        sumTemp += weatherData.getTemperature();
        sumPress += weatherData.getPressure();
        sumHum += weatherData.getHumidity();

        if (minTemp == 0.0f) {
            minTemp = weatherData.getTemperature();
        } else if (minTemp>weatherData.getTemperature()){ minTemp = weatherData.getTemperature();};
        if (maxTemp == 0.0f) maxTemp = weatherData.getTemperature(); else if (maxTemp < weatherData.getTemperature()) maxTemp =weatherData.getTemperature();
        if (minHum == 0.0f) minHum = weatherData.getTemperature(); else  if (minHum > weatherData.getHumidity()) minHum = weatherData.getHumidity();
        if (maxHum == 0.0f) maxHum = weatherData.getTemperature(); else if (maxHum < weatherData.getHumidity()) maxHum = weatherData.getHumidity();
        if (minPress == 0.0f) minPress = weatherData.getTemperature(); else if (minPress > weatherData.getPressure()) minPress = weatherData.getPressure();
        if (maxPress == 0.0f) maxPress = weatherData.getTemperature(); else if (maxPress < weatherData.getPressure()) maxPress = weatherData.getPressure();

        counter++;

        display();
    }
    
}
