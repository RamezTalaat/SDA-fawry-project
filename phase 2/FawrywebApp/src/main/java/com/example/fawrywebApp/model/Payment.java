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
	public void setService(Service service_)
	{
		service = service_;
	}
	public Service getService()
	{
		return service;
	}
}
