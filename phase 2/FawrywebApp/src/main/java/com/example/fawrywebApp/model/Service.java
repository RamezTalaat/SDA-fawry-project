package com.example.fawrywebApp.model;
import com.example.fawrywebApp.controller.Handler;

import java.util.Scanner;

import com.example.fawrywebApp.controller.Form;

public class Service {
	Scanner input = new Scanner(System.in);
	String name ;
	String type;
	public Discount discount;
	public Form form;
	public Handler handler;
	private int ID;
    private static int idCount = 0;
	public Service() {
		ID = ++idCount;
		discount = new InitialDiscount(); // to initialize services discounts
	}
	
	public void setName(String name_) 
	{
		name = name_;
	}
	public void setType(String type_) 
	{
		type = type_;
	}
	public void setForm(Form form_)
	{
		form = form_;
	}
	public void setHandler(Handler handler_)
	{
		handler = handler_;
	}
	public Form getForm()
	{
		return form;
	}
	public Handler getHandler()
	{
		return handler;
	}
	public String getName() 
	{
		return name;
	}
	public String getType() 
	{
		return type;
	}
	public void setReceipt(Receipt receipt_)
	{
		
	}
	public boolean payForService(User user) {
		return handler.handleForm(form, user, this);
	}
	public void setID(int ID_)
	{
		ID = ID_;
	}
	public int getID() {
		return ID;
	}
	
}

