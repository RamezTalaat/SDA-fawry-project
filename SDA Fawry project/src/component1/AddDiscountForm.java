package component1;

import java.util.Scanner;
enum discountType{
	overall,specific
}

public class AddDiscountForm {
	protected int amount;
	protected discountType type;
	protected	int minimumTransactions , maximumTransactions;
	protected String service;
	
	public AddDiscountForm() {
		minimumTransactions=0;
		maximumTransactions=0;
		service ="none";
	}
	
	public void getDiscountData() {
		Scanner input = new Scanner(System.in);
		int option;
		
		System.out.println("Choose Discount type");
		System.out.println("1- Overall discount		 (for users)");
		System.out.println("2- Specific discount     (for services)");
		option = input.nextInt();
		if(option ==1) {
			type = discountType.overall;
			System.out.println("Input minimum transactions per user");
			minimumTransactions = input.nextInt();
			System.out.println("Input maximum transactions per user");
			maximumTransactions = input.nextInt();
			
		}
		else if(option == 2) {
			type = discountType.specific;
			System.out.println("Input discounted service name");
			service = input.next();
		}
		else {
			System.out.println("ERROR : you did not choose option 1 or 2  , please try again");
			return;
		}
		System.out.println("Input discount amount $ :");
		amount= input.nextInt();
		
	}
}
