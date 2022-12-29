package com.example.fawrywebApp.model;

public class RefundTransaction extends Transaction{
	Transaction transaction;
	//Service	service;
	public RefundTransaction()
	{
		type = "refundTransaction";
	}
}
