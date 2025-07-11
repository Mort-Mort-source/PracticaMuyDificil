package com.clima.frontend.frontend_service.dto;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ClimateData {
    @NotNull @Min(-50) @Max(60)
    private Double temperature;

    @NotNull @Min(0) @Max(100)
    private Double humidity;

    // Getters / Setters

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Double getHumidity() { return humidity; }
    public void setHumidity(Double humidity) { this.humidity = humidity; }
}

