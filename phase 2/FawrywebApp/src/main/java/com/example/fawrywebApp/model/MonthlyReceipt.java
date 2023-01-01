package com.example.fawrywebApp.model;

public class MonthlyReceipt implements Receipt{

	public String bill = "Receipt will be sent monthly";
	public void getReceipt() {
		System.out.println("Receipt will be sent monthly");
	}
}
