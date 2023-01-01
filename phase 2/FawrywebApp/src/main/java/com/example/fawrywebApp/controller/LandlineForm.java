package com.example.fawrywebApp.controller;

import java.util.Scanner;

import com.example.fawrywebApp.model.CashPayment;
import com.example.fawrywebApp.model.CreditCardPayment;
import com.example.fawrywebApp.model.MonthlyReceipt;
import com.example.fawrywebApp.model.QuarterReceipt;
import com.example.fawrywebApp.model.Receipt;
import com.example.fawrywebApp.model.WalletPayment;

public class LandlineForm extends Form {

	Scanner input = new Scanner(System.in);
	public String landlineNumber;
	public String receipt;
	public void setReceipt(String receipt_)
	{
		receipt = receipt_;
	}
	public String getReceipt()
	{
		return receipt;
	}
	@Override
	public Receipt returnReceipt()
	{
		if(receipt == "Quarter") {
			return new QuarterReceipt();
		}
		return new MonthlyReceipt();
	}
	@Override
	public void viewForm() {
		// TODO Auto-generated method stub
		System.out.println("Enter your landline number");
		landlineNumber = input.next();
		System.out.println("Enter the amount");
		int amount_ = input.nextInt();
		setAmount(amount_);
	}
	@Override
	public PaymentController returnPaymentMethod() {
		if(paymentMethod.equals("Wallet")) {
			return new WalletPayment();
		}
		else if(paymentMethod.equals("Cash")) {
			return new CashPayment();
		}
		return new CreditCardPayment();
	}
	@Override
	public void getForm() {
		System.out.println("Landline number: "+landlineNumber);
		System.out.println("amount: "+getAmount());
	}
	@Override
	public void setForm(DummyForm dummyForm) {
		availablePaymentMethod = "Wallet & CreditCard & Cash on delivery";
		amount = dummyForm.amount;
		landlineNumber = dummyForm.landlineNumber;
		receipt = dummyForm.receipt;
		paymentMethod = dummyForm.paymentMethod;
	}
}
