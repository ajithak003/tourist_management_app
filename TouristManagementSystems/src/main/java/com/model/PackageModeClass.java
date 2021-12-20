package com.model;

import java.util.Objects;

public class PackageModeClass {
	
	private int packageId;
	private String name;
	private double priceTwoDays;
	private double priceThreeDays;
	private double pricefourDays;
	private String season;
	private String protocols;
	private String description;
	public PackageModeClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PackageModeClass(int packageId, String name, double priceTwoDays, double priceThreeDays,
			double pricefourDays, String season, String protocols, String description) {
		super();
		this.packageId = packageId;
		this.name = name;
		this.priceTwoDays = priceTwoDays;
		this.priceThreeDays = priceThreeDays;
		this.pricefourDays = pricefourDays;
		this.season = season;
		this.protocols = protocols;
		this.description = description;
	}
	
	
	public PackageModeClass(String name, double priceTwoDays, double priceThreeDays, double pricefourDays,
			String season, String protocols, String description) {
		super();
		this.name = name;
		this.priceTwoDays = priceTwoDays;
		this.priceThreeDays = priceThreeDays;
		this.pricefourDays = pricefourDays;
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
	public double getPriceTwoDays() {
		return priceTwoDays;
	}
	public void setPriceTwoDays(double priceTwoDays) {
		this.priceTwoDays = priceTwoDays;
	}
	public double getPriceThreeDays() {
		return priceThreeDays;
	}
	public void setPriceThreeDays(double priceThreeDays) {
		this.priceThreeDays = priceThreeDays;
	}
	public double getPricefourDays() {
		return pricefourDays;
	}
	public void setPricefourDays(double pricefourDays) {
		this.pricefourDays = pricefourDays;
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
		return "PackageMode  \n name=" + name + ", \n priceTwoDays=" + priceTwoDays
				+ ",\n priceThreeDays=" + priceThreeDays + ",\n pricefourDays=" + pricefourDays + ",\n season=" + season
				+ ",\n protocols=" + protocols + ",\n description=" + description ;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, packageId, priceThreeDays, priceTwoDays, pricefourDays);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackageModeClass other = (PackageModeClass) obj;
		return Objects.equals(name, other.name) && packageId == other.packageId
				&& Double.doubleToLongBits(priceThreeDays) == Double.doubleToLongBits(other.priceThreeDays)
				&& Double.doubleToLongBits(priceTwoDays) == Double.doubleToLongBits(other.priceTwoDays)
				&& Double.doubleToLongBits(pricefourDays) == Double.doubleToLongBits(other.pricefourDays);
	}
	
	

}
