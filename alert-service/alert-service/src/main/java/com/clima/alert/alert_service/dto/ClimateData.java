package com.clima.alert.alert_service.dto;

import java.time.LocalDateTime;

public class ClimateData {
    private Double temperature;
    private Double humidity;
    private LocalDateTime timestamp;

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Double getHumidity() { return humidity; }
    public void setHumidity(Double humidity) { this.humidity = humidity; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "Temp: " + temperature + ", Hum: " + humidity;
    }
}