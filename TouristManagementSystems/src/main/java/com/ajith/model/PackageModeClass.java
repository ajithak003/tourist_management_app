package com.ajith.model;

import java.util.Objects;

public class PackageModeClass {
	
	private int packageId;
	private String name;
	private double priceOneDays;
	private String season;
	private String protocols;
	private String description;
	public PackageModeClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PackageModeClass(int packageId, String name, double priceOneDays, String season, String protocols, String description) {
		super();
		this.packageId = packageId;
		this.name = name;
		this.priceOneDays = priceOneDays;
		this.season = season;
		this.protocols = protocols;
		this.description = description;
	}
	
	
	public PackageModeClass(String name, double priceOneDays,String season, String protocols, String description) {
		super();
		this.name = name;
		this.priceOneDays = priceOneDays;
		this.season = season;
		this.protocols = protocols;
		this.description = description;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPriceOneDays() {
		return priceOneDays;
	}
	public void setPriceTwoDays(double priceOneDays) {
		this.priceOneDays = priceOneDays;
	}
	
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getProtocols() {
		return protocols;
	}
	public void setProtocols(String protocols) {
		this.protocols = protocols;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PackageMode  \n location=" + name + ", \n priceOneDays=" + priceOneDays
				+ "\n season=" + season
				+ ",\n protocols=" + protocols + ",\n description=" + description ;
	}
	

}
