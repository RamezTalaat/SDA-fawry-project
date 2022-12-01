package component1;
import java.util.*;

public class FawryInterface {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		RegistrationForm registrationForm = new RegistrationForm();
		User currentUser = null;
		System.out.println("Welcome to our fawry system!");
		int option = 0;
		while(option != 3) {
			System.out.println("Please choose one of the following options:-");
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
		
		
		
	}

}
