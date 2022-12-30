package com.example.fawrywebApp.model;

public class OverallDisplayDiscount implements Discount{

	public int amount;
	public String name;
	public int minimumTransactions;
	public int maximumTransactions;
	public DiscountType type;
	
	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
	public OverallDisplayDiscount() {
		// TODO Auto-generated constructor stub
		type = DiscountType.overall;
	}

	
}
