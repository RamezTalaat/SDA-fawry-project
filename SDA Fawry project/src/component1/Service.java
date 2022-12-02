package component1;

import java.util.Scanner;

public class Service {
	Scanner input = new Scanner(System.in);
	String name ;
	String type;
	//Form form;
	//Handler handler
	//Vector<ServiceDiscount> discount = new Vector<ServiceDiscount>();
	
	public void setName(String name_) 
	{
		name = name_;
	}
	public void setType(String type_) 
	{
		type = type_;
	}
	public String getName() 
	{
		return name;
	}
	public String getType() 
	{
		return type;
	}
	public void getServices(Service service) 
	{
		System.out.println("Type: ");
		String name;
		name = input.next();
		
	}
}
