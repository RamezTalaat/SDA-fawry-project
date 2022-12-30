package com.example.fawrywebApp.database;

import java.util.Vector;

import com.example.fawrywebApp.model.DiscountDecorator;


public class DiscountDatabase {
	private static DiscountDatabase instance = null;
	public Vector<DiscountDecorator> discounts = new Vector<DiscountDecorator>();
	private DiscountDatabase() {
		// TODO Auto-generated constructor stub
		
	}	
	public static DiscountDatabase  getInstance() {
		if(instance == null) {
			instance = new DiscountDatabase();
		}
		return instance;
	}
	
	public void addDiscount(DiscountDecorator discount) {
		discounts.add(discount);
	}
}
