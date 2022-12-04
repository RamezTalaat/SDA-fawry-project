package component1;

import java.util.Scanner;

public class InternetForm extends Form{

	int amount;
	String number;

	@Override
	public void viewForm() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Input number");
		number = input.next();
		System.out.println("Input amount");
		amount = input.nextInt();
	}

	@Override
	public Payment getPaymentMethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
