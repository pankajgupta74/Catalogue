package com.rbs.catalogue.domain;

import org.springframework.data.annotation.Id;

public class Item {
	
	@Id
	private String item_id;
	private String item_name;
	private double unitPrice;
	private boolean isSurchargeApplicable;
	private double baseSurchargeRate;
	private double additionalSurchargeRate;
	
	public double getAdditionalSurchargeRate() {
		return additionalSurchargeRate;
	}
	public void setAdditionalSurchargeRate(double additionalSurchargeRate) {
		this.additionalSurchargeRate = additionalSurchargeRate;
	}
	public Item(String item_id, String item_name, double unitPrice, boolean isSurchargeApplicable,
			double baseSurchargeRate, double additionalSurchargeRate) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.unitPrice = unitPrice;
		this.isSurchargeApplicable = isSurchargeApplicable;
		this.baseSurchargeRate = baseSurchargeRate;
		this.additionalSurchargeRate = additionalSurchargeRate;
	}
	public double getBaseSurchargeRate() {
		return baseSurchargeRate;
	}
	public void setBaseSurchargeRate(double baseSurchargeRate) {
		this.baseSurchargeRate = baseSurchargeRate;
	}

	
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public boolean isSurchargeApplicable() {
		return isSurchargeApplicable;
	}
	public void setSurchargeApplicable(boolean isSurchargeApplicable) {
		this.isSurchargeApplicable = isSurchargeApplicable;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
