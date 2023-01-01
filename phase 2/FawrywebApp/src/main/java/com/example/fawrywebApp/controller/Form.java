package com.example.fawrywebApp.controller;

import com.example.fawrywebApp.model.Receipt;

public abstract class Form {
	protected int amount;
	protected String paymentMethod;
	public Form() {
		
	}
	public void setAmount(int amount_)
	{
		amount = amount_;
	}
	public int getAmount() {
		return amount;
	}
	public void setPaymentMethod(String paymentMethod_)
	{
		paymentMethod = paymentMethod_;
	}
	public String getPaymentMethod()
	{
		return paymentMethod;
	}
	public Receipt returnReceipt()
	{
		return null;
	}
	public abstract void setForm(DummyForm dummyForm);
	public abstract void viewForm();
	public abstract PaymentController returnPaymentMethod();
	public abstract void getForm();
	
}
