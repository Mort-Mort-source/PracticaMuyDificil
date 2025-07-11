package com.clima.storage.storage_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.ClimateData;

public interface ClimateDataRepository extends JpaRepository<ClimateData, Long> {
}