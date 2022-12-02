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
				break;
			}
			else {
				System.out.println("Sorry, invalid option");
			}
		}
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
			if(option == 1) {
				System.out.println("User name = " + currentUser.getName());
				System.out.println("User mail = " + currentUser.getMail());
				System.out.println("User wallet balance = " + currentUser.wallet.getAmount());
				System.out.println("User credit card balance = " + currentUser.getCreditCard());
			}
			else if(option == 2) {
				System.out.println("User "+currentUser.getName()+" logged out");
				currentUser = null;
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
			}
			else if(option == 3) {
				WalletForm walletForm = new WalletForm(transacionDataBase);
				walletForm.getWalletForm(currentUser);
			}
			else if(option == 4) {
				
			}
			else if(option == 5) {
				return;
			}
			else{
				System.out.println("Sorry, invalid option");
			}
			System.out.println("Choose another option:- ");
		}
	}

}
