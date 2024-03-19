package com.atm;

import java.util.Scanner;

public class ATM {

	double Balance;
	int PIN=8080;
	
	public void  checkPin()
	{
		System.out.println("WELCOME USER");
		System.out.println("Enter Your Pin");
		Scanner sc=new Scanner(System.in);
		int enteredpin=sc.nextInt();
		
		if(enteredpin==PIN)
		{
			menu();
		}
		else
		{
			System.out.println("Invalid Pin Enter a Valid Pin:");
		}
		checkPin();
	}
		public void menu()
		{
		    System.out.println("ENTER YOUR CHOICE");
			System.out.println("1. Check A/C Balance");
			System.out.println("2. Withdraw Money");
			System.out.println("3. Deposite Money");
			System.out.println("4. EXIT:");
			
			Scanner sc=new Scanner(System.in);
			int opt=sc.nextInt();
			
			if(opt==1)
			{
				checkBalance();
			}
			else if(opt==2)
			{
				withdrawMoney();
			}
			else if(opt==3)
			{
				depositeMoney();
			}
			else if(opt==4)
			{
				System.out.println("Thank You for Choice us visit Again...");
				return;
			}
			else
			{
				System.out.println("Enter a Valid Choice:");
			}
		}
		public void checkBalance()
		{
			System.out.println("Balance :"+Balance);
			menu();
		}
		public void withdrawMoney()
		{
			System.out.println("Enter Amount to Withdraw :");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		if(amount>Balance)
		{
			System.out.println("Insufficient Balance");
		}
		else
		{
			Balance=Balance-amount;
			System.out.println("Money Withdraw Successfully...");
		}
		menu();
		}
	public void depositeMoney()
	{
		System.out.println("ENTER YOUR AMOUNT TO DEPOSITE :");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		Balance= Balance+amount;
		System.out.println("Money Deposite Successfully....");
	}
	
}
