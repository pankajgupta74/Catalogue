package com.rbs.catalogue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rbs.catalogue.domain.Catalogue;
import com.rbs.catalogue.domain.Item;
import com.rbs.catalogue.service.CatalogueService;

@RestController
@ComponentScan("com.rbs.catalogue.service")
public class CatalogueController {
	
	@Autowired
	private CatalogueService service;
	
	@CrossOrigin(origins = "http://webapp-dummycompany.rhcloud.com")
	@RequestMapping("/items")
    public List<Catalogue> items(){
		
		return service.findAllItems();
		
    }
	
	

}
