package component1;
import java.util.*;



public class FawryInterface {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TransactionDataBase transacionDataBase = new TransactionDataBase();
		RegistrationForm registrationForm = new RegistrationForm();
		User currentUser = null;
		System.out.println("Welcome to our fawry system!");
		int option = 0;
		while(currentUser == null) {
			System.out.println("1- Sign in");
			System.out.println("2- Sign up");
			System.out.println("3- Exit");
			option = input.nextInt();
			if(option == 1) {
				currentUser = registrationForm.signIn();
			}
			else if(option == 2) {
				currentUser = registrationForm.signUp();
			}
			else if(option == 3) {
				return;
			}
			else {
				System.out.println("Sorry, invalid option");
			}
		}
		if(currentUser.getType() == userType.user){
			System.out.println("Please choose one of the following options:-");
			System.out.println("1- Print current user information");
			System.out.println("2- Log out and sign in with another user");
			System.out.println("3- Add money to your wallet");
			System.out.println("4- Request a refund for a completed transaction");
			System.out.println("5- Exit");
			System.out.println("Option:- ");
			option = 0;
			while(true) {
				option = input.nextInt();
				switch(option){
				case 1:{
					System.out.println("User name = " + currentUser.getName());
					System.out.println("User mail = " + currentUser.getMail());
					System.out.println("User wallet balance = " + currentUser.wallet.getAmount());
					System.out.println("User credit card balance = " + currentUser.getCreditCard());
					break;
				}
				case 2:{
					System.out.println("User "+currentUser.getName()+" logged out");
					currentUser = null;
					while(currentUser == null) {
						System.out.println("1- Sign in");
						System.out.println("2- Sign up");
						System.out.println("3- Exit");
						option = input.nextInt();
						if(option == 1) {
							currentUser = registrationForm.signIn();
							if(currentUser.getType() == userType.admin) break;  // to leave regular users menu and go to admin menu
						}
						else if(option == 2) {
							currentUser = registrationForm.signUp();
						}
						else if(option == 3) {
							return;
						}
						else {
							System.out.println("Sorry, invalid option");
						}
					}
					break;
					
				}
				case 3:{
					WalletForm walletForm = new WalletForm(transacionDataBase);
					walletForm.getWalletForm(currentUser);
					break;
					
				}
				case 4:{
					
					
				}
				case 5:{
					return;
				
				}
				default:{
					System.out.println("Sorry, invalid option");
					break;
				}
				
			}
				System.out.println("Choose another option:- ");
			}
		}
				
		else { // if user is an admin
			System.out.println("Please choose one of the following options:-");
			System.out.println("1- Add a new service");
			System.out.println("2- Add discount");
			System.out.println("3- List user transactions");
			System.out.println("4- List refund requests");
			System.out.println("5- Exit");
			System.out.println("Option:- ");
			option = input.nextInt();
			while(true) {
				switch(option){
				case 1:{
					
					break;
				}
				case 2:{
					
					break;
					
				}
				case 3:{
					TransactionDataBase transactionDataBase = new TransactionDataBase();
					TransactionController listerController = new PaymentController(transactionDataBase);
					listerController.listTransactions();
					break;
					
				}
				case 4:{
					
					break;
				}
				case 5:{
					
					return;
				
				}
				default:{
					System.out.println("Sorry, invalid option");
					return;
				}
			}
			
			
		}
		
	}

	}
}
