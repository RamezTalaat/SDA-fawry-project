package component1;

import java.util.Scanner;

public class LandlineForm extends Form {

	public LandlineForm(TransactionDataBase transactionDataBase) {
		super(transactionDataBase);
		// TODO Auto-generated constructor stub
	}
	Scanner input = new Scanner(System.in);
	public String landlineNumber;
	@Override
	public void viewForm() {
		// TODO Auto-generated method stub
		System.out.println("Enter your landline number");
		landlineNumber = input.next();
		System.out.println("Enter the amount");
		int amount_ = input.nextInt();
		setAmount(amount_);
	}
	@Override
	public PaymentController getPaymentMethod() {
		while(true) {
			System.out.println("Do you to change payment method 'Credit Card by default' (answer with yes or no)");
			String answer = input.next();
			if(answer.equals("yes")) {
				System.out.println("choose one of the following options:- ");
				System.out.println("1- Change payment method to pay with your wallet");
				System.out.println("2- Change payment method to pay cash (cash on delivery)");
				while(true) {
					int option = input.nextInt();
					if(option == 1) {
						return new WalletPayment(transactionDataBase);
					}
					else if(option == 2) {
						return new CashPayment(transactionDataBase);
					}
					System.out.println("Sorry, Ivalid input");
					System.out.println("Please enter another choice");
				}
			}
			else if(!answer.equals("no")) {
				System.out.println("Sorry, Ivalid input");
				System.out.println("Please enter another choice");
			}
			else {
				break;
			}
		}
		return new CreditCardPayment(transactionDataBase);
	}
	@Override
	public void getForm() {
		// TODO Auto-generated method stub
		System.out.println("Landline number: "+landlineNumber);
		System.out.println("amount: "+getAmount());
	}
}
