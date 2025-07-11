package com.clima.storage.storage_service.repository;


import org.springframework.data.repository.CrudRepository;

import com.clima.storage.storage_service.model.ClimateData;

public interface ClimateDataRepository extends CrudRepository<ClimateData, Long> {
}
