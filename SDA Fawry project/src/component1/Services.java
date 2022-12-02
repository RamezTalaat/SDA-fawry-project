package component1;

import java.util.Scanner;

public class Services {
	Scanner input = new Scanner(System.in);
	String name ;
	String type;
	//Form form;
	//Handler handler
	//Vector<ServiceDiscount> discount = new Vector<ServiceDiscount>();
	
	public void seName(String name_) 
	{
		name = name_;
	}
	public void seType(String type_) 
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
	public void getServices(Services services) 
	{
		System.out.println("Type: ");
	}
}
