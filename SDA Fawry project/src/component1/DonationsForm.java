package component1;

import java.util.Scanner;

public class DonationsForm implements Form{
	
	int amount;

	@Override
	public void viewForm() {
		// TODO Auto-generated method stub
		System.out.println("Input donation amount");
		Scanner input = new Scanner(System.in);
		amount = input.nextInt();
		
		
		
	}
}