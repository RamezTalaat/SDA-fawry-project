package com.example.fawrywebApp.model;


public class Payment extends Transaction {
	
	Service	service;
	String paymentType;
	public Payment()
	{
		type =  "paymentTransaction";
	}
	public void setPaymentType(String paymentType_)
	{
		paymentType = paymentType_;
	}
	public String getPaymentType()
	{
		return paymentType;
	}
}
