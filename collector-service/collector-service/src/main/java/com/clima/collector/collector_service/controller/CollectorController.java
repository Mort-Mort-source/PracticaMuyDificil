package com.clima.collector.collector_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.clima.collector.collector_service.dto.ClimateData;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/collector")
@Validated
public class CollectorController {

    private final RestTemplate restTemplate;
    private final String storageUrl;

    public CollectorController(RestTemplate restTemplate,
                               @Value("${services.storage.url}") String storageUrl) {
        this.restTemplate = restTemplate;
        this.storageUrl = storageUrl;
    }

    @PostMapping("/receive")
    public ResponseEntity<String> receive(@Valid @RequestBody ClimateData data) {
        // 1) Log
        System.out.println("Collector recibió: " + data);

        // 2) Forward a storage-service
        ResponseEntity<String> resp = restTemplate.postForEntity(storageUrl, data, String.class);

        // 3) Retornar al sensor el resultado
        if (resp.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Datos almacenados correctamente");
        } else {
            return ResponseEntity.status(502).body("Error al almacenar datos");
        }
    }
}