package com.example.fawrywebApp.controller;

import java.util.Vector;

import com.example.fawrywebApp.database.DiscountDatabase;
import com.example.fawrywebApp.database.ServiceDatabase;
import com.example.fawrywebApp.database.UsersDatabase;
import com.example.fawrywebApp.model.Discount;
import com.example.fawrywebApp.model.DiscountDecorator;
import com.example.fawrywebApp.model.DiscountType;
import com.example.fawrywebApp.model.OverallDisplayDiscount;
import com.example.fawrywebApp.model.SpecificDisplayDiscount;

public class DiscountController {

	DiscountDatabase discountDatabase = DiscountDatabase.getInstance();
	ServiceDatabase serviceDatabase = ServiceDatabase.getInstance();
	UsersDatabase usersDatabase = UsersDatabase.getInstance();
	
	public void makeDiscount(DiscountDecorator discount_)
	{
		DiscountDecorator discount = discount_;
		
		/*DiscountDecorator discount = new DiscountDecorator(form.amount);
		discount.amount =  form.amount;
		discount.type = form.type;
		discount.minimumTransactions = form.minimumTransactions;
		discount.maximumTransactions = form.maximumTransactions;
		discount.service = form.service;
		discount.name = form.name;*/
		discountDatabase.addDiscount(discount);//discount added to database
		
		if(discount.type == DiscountType.overall) { // add to users
			for (int i = 0; i < usersDatabase.users.size(); i++) {// to add discount to users
				int numberOfTransactions = usersDatabase.users.get(i).transactions.size();
				if(numberOfTransactions >= discount.minimumTransactions && numberOfTransactions <= discount.maximumTransactions) {
					discount.setWrappee(usersDatabase.users.get(i).discount); // to make the new discount wrap the old one
					usersDatabase.users.get(i).discount = discount;
				}
			}
		}
		else{ // add to services
			for (int i = 0; i < serviceDatabase.services.size(); i++) {// to add discount to users
				//Service service = serviceDatabase.services.get(i);
				//System.out.println("heeeeeeeeeeeeeeeeey");
				if(serviceDatabase.services.get(i).getName().equals(discount.service)) {
					discount.setWrappee(serviceDatabase.services.get(i).discount); // to make the new discount wrap the old one
					serviceDatabase.services.get(i).discount = discount;
					//service.discount = discount;
					//service.discount.getAmount();
					break;
				}
			}
		}
		
	}
	
	public void getDiscounts()
	{
		for (int i = 0; i < discountDatabase.discounts.size(); i++) {
			DiscountDecorator discount = discountDatabase.discounts.get(i);
			System.out.println("Discount name : " + discount.name );
			System.out.println("Discount amount :" + discount.amount + "$" );
		}
	}
	public Vector<Discount> getDisplayDiscounts(){  // this function is meant to return a vector of discounts that would be displayed -  
		if(discountDatabase.discounts.isEmpty())   // only with the data that the user is supposed to know about discounts of any type
			return null;
		Vector<Discount> displayDiscounts = new Vector<Discount>();
		for (int i = 0; i < discountDatabase.discounts.size(); i++) {
			if(discountDatabase.discounts.get(i).type == DiscountType.specific) {
				SpecificDisplayDiscount discountDisplay = new SpecificDisplayDiscount();
				
				discountDisplay.amount = discountDatabase.discounts.get(i).amount;
				discountDisplay.name = discountDatabase.discounts.get(i).name;
				discountDisplay.service = discountDatabase.discounts.get(i).service;
				displayDiscounts.add(discountDisplay);
			}
			else {
				OverallDisplayDiscount discountDisplay = new OverallDisplayDiscount();
				discountDisplay.amount = discountDatabase.discounts.get(i).amount;
				discountDisplay.name = discountDatabase.discounts.get(i).name;
				discountDisplay.minimumTransactions = discountDatabase.discounts.get(i).minimumTransactions;
				discountDisplay.maximumTransactions = discountDatabase.discounts.get(i).maximumTransactions;
				displayDiscounts.add(discountDisplay);
			}
			
		}
		return displayDiscounts;
	}
}
