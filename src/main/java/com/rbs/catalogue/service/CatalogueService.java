package com.rbs.catalogue.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rbs.catalogue.domain.Catalogue;
import com.rbs.catalogue.domain.Item;
import com.rbs.catalogue.domain.SurchargeRate;
import com.rbs.catalogue.repository.ItemRepository;
import com.rbs.catalogue.repository.SurchargeRateRepository;

@Service
@Component
@ComponentScan("com.rbs.catalogue.repository")

public class CatalogueService {

	private static final Logger logger = LoggerFactory.getLogger(CatalogueService.class);

	public CatalogueService() {
		super();
	}

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private SurchargeRateRepository rateRepo;

	public ItemRepository getItemRepo() {
		return itemRepo;
	}

	public void setItemRepo(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}

	public List<Catalogue> findAllItems() {

		List<Item> catalogueItems = itemRepo.findAll();

		List<SurchargeRate> rates = rateRepo.findAll();

		List<Catalogue> catalogueList = new ArrayList<Catalogue>();

		SurchargeRate mgmtSurchargeRate = (SurchargeRate) CollectionUtils.find(rates, new Predicate() {
			public boolean evaluate(Object userType) {
				return ((SurchargeRate) userType).getUserType().equals("M");
			}
		});

		SurchargeRate nonMgmtSurchargeRate = (SurchargeRate) CollectionUtils.find(rates, new Predicate() {
			public boolean evaluate(Object userType) {
				return ((SurchargeRate) userType).getUserType().equals("NM");
			}
		});

		for (SurchargeRate myRate : rates) {

			String userType = myRate.getUserType();
			Catalogue catalogue = new Catalogue();
			catalogue.setUserType(userType);
			catalogue.setUserTypeDescription(myRate.getUserTypeDescription());
			List<Item> finalCatalogueItems = new ArrayList<Item>();
			for (Item myItem : catalogueItems) {
				Item newItem = new Item();
				BeanUtils.copyProperties(myItem, newItem);
				finalCatalogueItems.add(newItem);
				if (newItem.isSurchargeApplicable()) {
					if ("M".equals(userType)) {
						newItem.setBaseSurchargeRate(mgmtSurchargeRate.getBaseSurchargeRate());
						newItem.setAdditonalSurchargeRate(mgmtSurchargeRate.getAdditionalSurchargeRate());

					} else {
						newItem.setBaseSurchargeRate(nonMgmtSurchargeRate.getBaseSurchargeRate());

					}

				} else {
					if ("M".equals(userType)) {
						newItem.setAdditonalSurchargeRate(mgmtSurchargeRate.getAdditionalSurchargeRate());

					}
				}

			}
			catalogue.setItems(finalCatalogueItems);
			catalogueList.add(catalogue);

		}

		return catalogueList;
	}
}
