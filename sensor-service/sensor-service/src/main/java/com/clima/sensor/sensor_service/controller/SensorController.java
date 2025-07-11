package com.clima.sensor.sensor_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clima.dto.ClimateData;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @PostMapping("/data")
    public ResponseEntity<String> receiveClimateData(@RequestBody ClimateData data) {
        System.out.println("Datos recibidos: " + data);
        return ResponseEntity.ok("Datos recibidos correctamente");
    }
}
