package com.example.fawrywebApp.controller;

import java.util.Scanner;

import com.example.fawrywebApp.model.CreditCardPayment;
import com.example.fawrywebApp.model.WalletPayment;

public class InternetForm extends Form{

	public String homeTelephoneNumber;
	Scanner input = new Scanner(System.in);
	@Override
	public void viewForm() {
		System.out.println("Enter your home telephone number");
		homeTelephoneNumber = input.next();
		System.out.println("Enter the amount");
		int amount_ = input.nextInt();
		setAmount(amount_);
	}

	@Override
	public PaymentController returnPaymentMethod() {
		if(paymentMethod.equals("Wallet")) {
			return new WalletPayment();
		}
		System.out.println("creditCard payment");
		return new CreditCardPayment();
	}

	@Override
	public void getForm() {
		System.out.println("home telephone number: "+homeTelephoneNumber);
		System.out.println("amount: "+getAmount());
	}

	@Override
	public void setForm(DummyForm dummyForm) {
		amount = dummyForm.amount;
		homeTelephoneNumber = dummyForm.homeTelephoneNumber;
		paymentMethod = dummyForm.paymentMethod;
	}
}
