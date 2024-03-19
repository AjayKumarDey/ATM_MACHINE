package com.rentalcar;

public class Car {

	
	private String carId;
	private String Model;
	private String brand;
	private double basePricePerday;
	private boolean isAvailable;
	
	
	public Car(String carId, String model, String brand, double basePricePerday) {
		
		this.carId = carId;
		Model = model;
		this.brand = brand;
		this.basePricePerday = basePricePerday;
		this.isAvailable = true;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double calculatePrice(int rentalDays)
	{
		return basePricePerday*rentalDays;
	}
	public boolean isavailable()
	{
		return isAvailable;
	}
	public void rent()
	{
		isAvailable=false;
	}
	public void  	rentalCar()
	{
		isAvailable=true;
	}
	
	public double getBasePricePerday() {
		return basePricePerday;
	}
	public void setBasePricePerday(double basePricePerday) {
		this.basePricePerday = basePricePerday;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}
