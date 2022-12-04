package component1;

import java.util.Scanner;

public class DonationsForm extends Form{
	
	int amount;

	@Override
	public void viewForm() {
		// TODO Auto-generated method stub
		System.out.println("Input donation amount");
		Scanner input = new Scanner(System.in);
		amount = input.nextInt();
	}

	@Override
	public Payment getPaymentMethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
