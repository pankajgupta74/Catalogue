package com.rbs.catalogue.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.rbs.catalogue.domain.SurchargeRate;

@Cacheable("surchargerates")
public interface SurchargeRateRepository extends MongoRepository<SurchargeRate, String> {
    
}