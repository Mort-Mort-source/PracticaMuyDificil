package com.clima.dto;

public class ClimateData {
    private double temperature;
    private double humidity;

    // Getters y setters
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }

    @Override
    public String toString() {
        return "Temp: " + temperature + "°C, Hum: " + humidity + "%";
    }
}
