package com.example.fawrywebApp.controller;

import java.util.Scanner;

import com.example.fawrywebApp.model.CashPayment;
import com.example.fawrywebApp.model.CreditCardPayment;
import com.example.fawrywebApp.model.WalletPayment;

public class DonationsForm extends Form{
	Scanner input = new Scanner(System.in);
	public String organizationName;
	
	public void viewForm() {
		// TODO Auto-generated method stub
		System.out.println("Enter donation amount");
		int amount_ = input.nextInt();
		setAmount(amount_);
		System.out.println("Enter the organization you want to donate for");
		organizationName = input.next();
	}
	
	public PaymentController returnPaymentMethod() {
		if (paymentMethod.equals("Cash")) {
			return new CashPayment();
		}
		else if (paymentMethod.equals("Wallet")) {
			return new WalletPayment();
		}
		return new CreditCardPayment();
	}
	
	public void getForm() {
		System.out.println("Donation amount: "+getAmount());
		System.out.println("Orgnization name: "+organizationName);
		
	}

	public void setForm(DummyForm dummyForm) {
		availablePaymentMethod = "Wallet & CreditCard & Cash on delivery";
		amount = dummyForm.amount;
		organizationName = dummyForm.organizationName;
		paymentMethod = dummyForm.paymentMethod;
		
	}
}
