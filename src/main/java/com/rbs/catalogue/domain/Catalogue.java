package com.rbs.catalogue.domain;

import java.util.List;

public class Catalogue {
	
	private String userType;
	private String userTypeDescription;
	public Catalogue(String userType, String userTypeDescription, List<Item> items) {
		super();
		this.userType = userType;
		this.userTypeDescription = userTypeDescription;
		this.items = items;
	}
	public String getUserTypeDescription() {
		return userTypeDescription;
	}
	public void setUserTypeDescription(String userTypeDescription) {
		this.userTypeDescription = userTypeDescription;
	}
	private List<Item> items;
	public Catalogue(String userType, List<Item> items) {
		super();
		this.userType = userType;
		this.items = items;
	}
	public Catalogue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

}
