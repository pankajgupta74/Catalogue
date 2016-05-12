package com.rbs.catalogue.domain;

public class SurchargeRate {
	
	private String userType;
	private String userTypeDescription;
	public String getUserTypeDescription() {
		return userTypeDescription;
	}
	public void setUserTypeDescription(String userTypeDescription) {
		this.userTypeDescription = userTypeDescription;
	}
	private double baseSurchargeRate = 0.0;
	private double additionalSurchargeRate = 0.0;
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public double getBaseSurchargeRate() {
		return baseSurchargeRate;
	}
	public void setBaseSurchargeRate(double baseSurchargeRate) {
		this.baseSurchargeRate = baseSurchargeRate;
	}
	public SurchargeRate(String userType, String userTypeDescription, double baseSurchargeRate,
			double additionalSurchargeRate) {
		super();
		this.userType = userType;
		this.userTypeDescription = userTypeDescription;
		this.baseSurchargeRate = baseSurchargeRate;
		this.additionalSurchargeRate = additionalSurchargeRate;
	}
	public double getAdditionalSurchargeRate() {
		return additionalSurchargeRate;
	}
	public void setAdditionalSurchargeRate(double additionalSurchargeRate) {
		this.additionalSurchargeRate = additionalSurchargeRate;
	}

	

}
