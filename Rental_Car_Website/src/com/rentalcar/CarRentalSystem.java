package com.rentalcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {

	
	private List<Car> cars;
	private List<Customer> customers;
	private  List<Rental> rentals;
	
	public CarRentalSystem()
	{
		cars= new ArrayList<>();
		customers=new ArrayList<>();
		rentals=new ArrayList<>();
		
	}
	
	public void addCar(Car car)
	{
		cars.add(car);
	}
	
	public void addCustomer(Customer customer)
	{
		customers.add(customer);
	}
	
	public void rentCar(Car car,Customer customer,int days)
	{
		if(car.isAvailable())
		{
		  car.rent();
			rentals.add(new Rental(car,customer,days));
		}
		else
		{
			System.out.println("Car is not Available for rent");
		}
	}
	
	public void returnCar(Car car)
	{
		car.rentalCar();
		Rental rentaltoRemove=null;
		for(Rental rental:rentals)
		{
			if(rental.getCar()==car)
			{
				rentaltoRemove=rental;
				break;
			}
		}
		if(rentaltoRemove!=null)
		{
			rentals.remove(rentaltoRemove);
			System.out.println("car return successfully !!!!");
		}
		else
		{
			System.out.println("car was not rented..!!!!");
		}
	}
	
	public void menu()
	{
	Scanner sc=new Scanner(System.in);	
	
	while(true)
	{
		System.out.println("welcome to Car Rental System...!!");
		System.out.println("1. Rent a Car");
		System.out.println("2. Return a Car");
		System.out.println("3. Exit");
		System.out.println("Enter your Choice:....");
		
		int choice=sc.nextInt();
		sc.nextLine();
		
		if(choice==1)
		{
			System.out.println("rent a car:  ?");
			System.out.println("Enter your Name:");
			String customerName=sc.nextLine();
			
			System.out.println("Available Cars: ");
			for(Car car: cars)
			{
				if(car.isAvailable())
				{
					System.out.println(car.getCarId()+"--"+car.getModel()+"--"+car.getBrand());
				}
			}
			System.out.println("Enter the carId you wants to rent:---");
			String carId=sc.nextLine();
			System.out.println("Enter the number of days for rent:--");
			int rentalDays=sc.nextInt();
			sc.nextLine();
			
			
			Customer newCustomer=new Customer("CUS"+(customers.size()+1), customerName);
			
			addCustomer(newCustomer);
			
			Car selectedCar=null;
			for(Car car:cars)
			{
				if(car.getCarId().equals(carId)&& car.isAvailable())
				{
					selectedCar=car;
					break;
				}
			}
			
			if(selectedCar!=null)
			{
				double totalPrice=selectedCar.calculatePrice(rentalDays);
				System.out.println("Rental Information");
				System.out.println("Customer Id:"+newCustomer.getCustomerId());
				System.out.println("Customer Name :"+newCustomer.getName());
				System.out.println("Car: "+selectedCar.getBrand()+"--"+selectedCar.getModel());
				System.out.println("Rental Days"+rentalDays);
				System.out.println("Total Price: "+totalPrice);
				
				System.out.println("Confirm rental (YES/NO) ");
				String confirm= sc.nextLine();
				
				if(confirm.equalsIgnoreCase("YES"))
				{
					rentCar(selectedCar, newCustomer, rentalDays);
					System.out.println("rent successfully --");
				}
				else
				{
					System.out.println("rented Cancelled...");
				}
				
			}
			else
			{
				System.out.println("invalid car selection or car not available for rent.");
			}
			
		}
		else if(choice==2)
		{
			System.out.println("return a Car:");
			System.out.println("Enter the Car ID you want to return :");
			String carId=sc.nextLine();
			
			Car carToReturn =null;
			for(Car car:cars)
			{
				if(car.getCarId().equals(carId)&&!car.isAvailable())
				{
					carToReturn=car;
					break;
				}
			}
			if(carToReturn!=null)
			{
				Customer customer=null;
				for(Rental rental:rentals)
				{
					if(rental.getCar()==carToReturn)
					{
						customer=rental.getCustomer();
						break;
					}
				}
				if(customer!=null)
				{
					returnCar(carToReturn);
					System.out.println("Car return Successfully by "+customer.getName());
				}
				else {
					System.out.println("car was not rented or renatal information is missing ");
				}
				
			}
			else {
				System.out.println("Invalid carId or car is not  rented----");
			}
		}
		else if(choice==3)
		{
			System.out.println("Invalid choice  Please  enter a valid option:");
		}
		System.out.println("Thank you for using the car rental system!");
	}
	
		
	}
}
