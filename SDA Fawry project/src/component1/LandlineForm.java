package component1;

import java.util.Scanner;

public class LandlineForm extends Form {

	int amount ;
	String landlineNumber;
	@Override
	public void viewForm() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Input landline number");
		landlineNumber = input.next();
		
		System.out.println("Input donation amount");
		
		amount = input.nextInt();
	}
	@Override
	public Payment getPaymentMethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
