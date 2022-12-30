package com.example.fawrywebApp.model;

public class SpecificDisplayDiscount implements Discount{

	public int amount;
	public String name;
	public String service;
	public DiscountType type;
	
	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
	public SpecificDisplayDiscount() {
		// TODO Auto-generated constructor stub
		type = DiscountType.specific;
	}

}
