package com.module;

import java.util.Objects;

public class PackageModeClass {
	
	private String name;
	private double priceTwoDays;
	private double priceThreeDays;
	private double pricefourDays;
	private int noOfDays;
	private String season;
	private String protocols;
	private String forcast;
	private String description;
	public PackageModeClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PackageModeClass(String name, double priceTwoDays, double priceThreeDays, double pricefourDays, int noOfDays,
			String season, String protocols, String forcast, String description) {
		super();
		this.name = name;
		this.priceTwoDays = priceTwoDays;
		this.priceThreeDays = priceThreeDays;
		this.pricefourDays = pricefourDays;
		this.noOfDays = noOfDays;
		this.season = season;
		this.protocols = protocols;
		this.forcast = forcast;
		this.description = description;
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
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
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
	public String getForcast() {
		return forcast;
	}
	public void setForcast(String forcast) {
		this.forcast = forcast;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "PackageModeClass [name=" + name + ", priceTwoDays=" + priceTwoDays + ", priceThreeDays="
				+ priceThreeDays + ", pricefourDays=" + pricefourDays + ", noOfDays=" + noOfDays + ", season=" + season
				+ ", protocols=" + protocols + ", forcast=" + forcast + ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, noOfDays, priceThreeDays, priceTwoDays, pricefourDays, season);
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
		return Objects.equals(name, other.name) && noOfDays == other.noOfDays
				&& Double.doubleToLongBits(priceThreeDays) == Double.doubleToLongBits(other.priceThreeDays)
				&& Double.doubleToLongBits(priceTwoDays) == Double.doubleToLongBits(other.priceTwoDays)
				&& Double.doubleToLongBits(pricefourDays) == Double.doubleToLongBits(other.pricefourDays)
				&& Objects.equals(season, other.season);
	}
	

}
