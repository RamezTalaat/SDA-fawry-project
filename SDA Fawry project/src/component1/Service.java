package component1;

import java.util.Scanner;

public class Service {
	Scanner input = new Scanner(System.in);
	String name ;
	String type;
	public Discount discount;
	public Form form;
	public Handler handler;
	public Service() {
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
	
	public void payForService(User user) {
		form.viewForm();
		handler.handleForm(form, user, this);
	}
}

