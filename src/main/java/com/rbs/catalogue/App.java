package com.rbs.catalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.rbs.catalogue.domain.Item;
import com.rbs.catalogue.domain.SurchargeRate;
import com.rbs.catalogue.repository.ItemRepository;
import com.rbs.catalogue.repository.MongoConfig;
import com.rbs.catalogue.repository.SurchargeRateRepository;

@SpringBootApplication

@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
@ComponentScan
@Import(MongoConfig.class)
public class App implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private SurchargeRateRepository surchargeRep;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		surchargeRep.deleteAll();

		surchargeRep.save(new SurchargeRate("M", "Management", 0.10, 0.05));
		surchargeRep.save(new SurchargeRate("NM", "Non-Management",0.10, 0.00));

		itemRepo.deleteAll();
		itemRepo.save(new Item("001",  "Shirt", 27.99, true, 0.0,0.0));
		itemRepo.save(new Item("002", "Trouser", 18.99, true, 0.0,0.0));
		itemRepo.save(new Item("003", "Physics Book", 9.75, false, 0.0,0.0));
		itemRepo.save(new Item("004", "Tie", 11.25, true, 0.0,0.0));

	}

}