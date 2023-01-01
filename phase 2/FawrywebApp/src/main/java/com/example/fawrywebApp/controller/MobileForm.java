package com.example.fawrywebApp.controller;

import java.util.Scanner;

import com.example.fawrywebApp.model.CreditCardPayment;
import com.example.fawrywebApp.model.WalletPayment;

public class MobileForm extends Form{
	/*public MobileForm(TransactionDataBase transactionDataBase) {
		super(transactionDataBase);
		// TODO Auto-generated constructor stub
	}*/

	Scanner input = new Scanner(System.in);
	public String mobileNumber;
	@Override
	public void viewForm() {
		// TODO Auto-generated method stub
		System.out.println("Enter your mobile number");
		mobileNumber = input.next();
		System.out.println("Enter the amount");
		int amount_ = input.nextInt();
		setAmount(amount_);
	}

	@Override
	public PaymentController returnPaymentMethod() {
		if(paymentMethod.equals("Wallet")) {
			return new WalletPayment();
		}
		return new CreditCardPayment();
	}

	@Override
	public void getForm() {
		System.out.println("mobile number: "+mobileNumber);
		System.out.println("amount: "+getAmount());
	}

	@Override
	public void setForm(DummyForm dummyForm) {
		amount = dummyForm.amount;
		mobileNumber = dummyForm.mobileNumber;
		paymentMethod = dummyForm.paymentMethod;
		
	}
}
