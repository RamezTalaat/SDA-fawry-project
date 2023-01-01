package com.example.fawrywebApp.model;

public class QuarterReceipt implements Receipt{

	public String bill = "Receipt will be sent every quarter (every 3 months)";
	public void getReceipt() {
		System.out.println("Receipt will be sent every quarter (every 3 months)");
	}
	
}
