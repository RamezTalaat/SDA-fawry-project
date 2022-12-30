package com.example.fawrywebApp.controller;

import java.util.Scanner;

import com.example.fawrywebApp.model.CashPayment;
import com.example.fawrywebApp.model.CreditCardPayment;
import com.example.fawrywebApp.model.WalletPayment;

public class DonationsForm extends Form{
	/*public DonationsForm(TransactionDataBase transactionDataBase) {
		super(transactionDataBase);
		// TODO Auto-generated constructor stub
	}*/
	Scanner input = new Scanner(System.in);
	public String OrganizationName;
	@Override
	public void viewForm() {
		// TODO Auto-generated method stub
		System.out.println("Enter donation amount");
		int amount_ = input.nextInt();
		setAmount(amount_);
		System.out.println("Enter the organization you want to donate for");
		OrganizationName = input.next();
	}
	@Override
	public PaymentController getPaymentMethod() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("Do you to change payment method 'Credit Card by default' (answer with yes or no)");
			String answer = input.next();
			if(answer.equals("yes")) {
				System.out.println("choose one of the following options:- ");
				System.out.println("1- Change payment method to pay with your wallet");
				System.out.println("2- Change payment method to pay cash (cash on delivery)");
				while(true) {
					int option = input.nextInt();
					if(option == 1) {
						return new WalletPayment();
					}
					else if(option == 2) {
						return new CashPayment();
					}
					System.out.println("Sorry, Ivalid input");
					System.out.println("Please enter another choice");
				}
			}
			else if(!answer.equals("no")) {
				System.out.println("Sorry, Ivalid input");
				System.out.println("Please enter another choice");
			}
			else {
				break;
			}
		}
		return new CreditCardPayment();
	}
	@Override
	public void getForm() {
		// TODO Auto-generated method stub
		System.out.println("Donation amount: "+getAmount());
		System.out.println("Orgnization name: "+OrganizationName);
		
	}
}
