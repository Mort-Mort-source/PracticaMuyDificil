package com.clima.storage.storage_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.clima.storage.storage_service.repository.ClimateDataRepository;

import dto.ClimateData;

@RestController
@RequestMapping("/storage")
public class StorageController {

    private final ClimateDataRepository repository;

    public StorageController(ClimateDataRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ClimateData data) {
        repository.save(data);
        return ResponseEntity.ok("Datos almacenados correctamente");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
