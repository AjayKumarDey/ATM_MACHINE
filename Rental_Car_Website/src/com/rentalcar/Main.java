package com.rentalcar;

public class Main {
public static void main(String[] args) {
	CarRentalSystem c=new CarRentalSystem();
	Car car1=new Car("A001", "HONDA", "CITY", 400.0);
	Car car2=new Car("A002", "SUZUKI", "SWIFT", 500.0);
	Car car3=new Car("A003", "Hyundai", "i10", 700.0);
	Car car4=new Car("A004", "TATA", "NEXON", 900.0);
	
	
c.addCar(car1);
c.addCar(car2);
c.addCar(car3);
c.addCar(car4);
c.menu();

}
}
