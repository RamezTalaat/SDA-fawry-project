package component1;

import java.util.Scanner;

public class InternetForm extends Form{
	/*public InternetForm(TransactionDataBase transactionDataBase) {
		super(transactionDataBase);
		// TODO Auto-generated constructor stub
	}*/

	Scanner input = new Scanner(System.in);
	public String homeTelephoneNumber;
	@Override
	public void viewForm() {
		// TODO Auto-generated method stub
		System.out.println("Enter your home telephone number");
		homeTelephoneNumber = input.next();
		System.out.println("Enter the amount");
		int amount_ = input.nextInt();
		setAmount(amount_);
	}

	@Override
	public PaymentController getPaymentMethod() {
		System.out.println("Do you to change payment method to pay with wallet? 'Credit Card by default' (answer with yes or no)");
		while(true) {
			String answer = input.next();
			if(answer.equals("yes")) {
				return new WalletPayment();
			}
			else if(!answer.equals("no")) {
				System.out.println("Sorry, Ivalid input");
				System.out.println("Please enter another choice");
			}
			else {
				break;
			}
		}
		return new CreditCardPayment();
	}

	@Override
	public void getForm() {
		// TODO Auto-generated method stub
		System.out.println("home telephone number: "+homeTelephoneNumber);
		System.out.println("amount: "+getAmount());
	}
}
