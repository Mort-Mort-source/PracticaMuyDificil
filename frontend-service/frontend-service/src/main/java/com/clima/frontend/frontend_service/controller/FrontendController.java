package com.clima.frontend.frontend_service.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.clima.frontend.frontend_service.dto.ClimateData;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/frontend")
public class FrontendController {

    private final RestTemplate restTemplate;
    private final String collectorUrl;
    private final String alertUrl;

    public FrontendController(
        @Value("${endpoints.collector}") String collectorUrl,
        @Value("${endpoints.alert}") String alertUrl
    ) {
        this.restTemplate = new RestTemplate();
        this.collectorUrl = collectorUrl;
        this.alertUrl = alertUrl;
    }

    @PostMapping("/send-data")
    public ResponseEntity<String> sendData(@Valid @RequestBody ClimateData data) {
        StringBuilder response = new StringBuilder();

        // Enviar a collector
        try {
            ResponseEntity<String> collectorResp = restTemplate.postForEntity(collectorUrl, data, String.class);
            response.append("Collector: ").append(collectorResp.getBody()).append("\n");
        } catch (RestClientException e) {
            response.append("Collector: ❌ Error al enviar datos\n");
        }

        // Enviar a alert
        try {
            ResponseEntity<String> alertResp = restTemplate.postForEntity(alertUrl, data, String.class);
            response.append("Alert: ").append(alertResp.getBody());
        } catch (RestClientException e) {
            response.append("Alert: ❌ Error al consultar alerta");
        }

        return ResponseEntity.ok(response.toString());
    }
}

