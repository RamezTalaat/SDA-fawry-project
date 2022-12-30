package com.example.fawrywebApp.model;

public class DiscountDecorator implements Discount {
	public Discount wrappee;
	public int amount;
	public DiscountType type;
	public	int minimumTransactions;
	public int maximumTransactions;
	public String service;
	public String name;
	
	public DiscountDecorator( int _amount) {
		// TODO Auto-generated constructor stub
		wrappee = null;
		amount =_amount;
	}
	public void setWrappee(Discount parent) {
		wrappee = parent;
	}

	@Override
	public int getAmount() { // returns the amount of itself and other discounts
		// TODO Auto-generated method stub
		if(wrappee != null)
			return amount + wrappee.getAmount();
		return amount;
		
	}
	
}
