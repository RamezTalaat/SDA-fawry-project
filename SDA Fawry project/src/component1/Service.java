/*package component1;

import java.util.Scanner;

public class Service {
	Scanner input = new Scanner(System.in);
	String name ;
	String type;
	Form form;
	Handler handler;
	
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
	public Handler getHandler()
	{
		return handler;
	}
	public Form getForm()
	{
		return form;
	}
	public String getName() 
	{
		return name;
	}
	public String getType() 
	{
		return type;
	}
}*/
package component1;

import java.util.Scanner;

public class Service {
	Scanner input = new Scanner(System.in);
	String name ;
	String type;
	Discount discount;
	public Form form;
	public Handler handler;
	//Vector<ServiceDiscount> discount = new Vector<ServiceDiscount>();
	public Service() {
		// TODO Auto-generated constructor stub
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
	/*public void getServices(Service service) 
	{
		System.out.println("Type: ");
		String name;
		name = input.next();
	}*/
	public void payForService(User user) {
		form.viewForm();
		handler.handleForm(form, user, this);
	}
}

