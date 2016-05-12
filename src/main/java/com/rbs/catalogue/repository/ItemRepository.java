package com.rbs.catalogue.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.rbs.catalogue.domain.Item;

import java.util.List;

@Cacheable("Item")
public interface ItemRepository extends MongoRepository<Item, String> {
    public List<Item> findAll();
}