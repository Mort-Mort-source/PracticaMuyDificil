package com.clima.alert.alert_service.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clima.alert.alert_service.dto.ClimateData;

@RestController
@RequestMapping("/alert")
public class AlertController {

    @PostMapping("/check")
    public ResponseEntity<String> checkAlert(@RequestBody ClimateData data) {
        StringBuilder alert = new StringBuilder();

        if (data.getTemperature() != null) {
            if (data.getTemperature() > 40) {
                alert.append("⚠️ Temperatura muy alta: ").append(data.getTemperature()).append("°C\n");
            } else if (data.getTemperature() < 0) {
                alert.append("❄️ Temperatura bajo cero: ").append(data.getTemperature()).append("°C\n");
            }
        }

        if (data.getHumidity() != null && data.getHumidity() > 90) {
            alert.append("💧 Humedad excesiva: ").append(data.getHumidity()).append("%\n");
        }

        if (alert.isEmpty()) {
            return ResponseEntity.ok("✅ Sin alertas");
        } else {
            return ResponseEntity.ok(alert.toString());
        }
    }
}