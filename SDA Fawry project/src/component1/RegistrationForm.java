package component1;
import java.util.*;

public class RegistrationForm {
	public RegistrationController regestrationController = new RegistrationController();
	Scanner input = new Scanner(System.in);
	public RegistrationForm()
	{
		
	}
	public User signIn()
	{
		User currentUser;
		String mail, password;
		System.out.println("Enter your mail:- ");
		mail = input.next();
		System.out.println("Enter your password:- ");
		password = input.next();
		currentUser = regestrationController.checkUserExistence(mail, password);
		if(currentUser != null) {
			return currentUser;
		}
		System.out.println("Wrong password or there is no such user");
		return null;
	}
	public User signUp()
	{
		User currentUser;
		String userMail, userPassword, userName;
		System.out.println("Enter your name:- ");
		userName = input.next();
		System.out.println("Enter your mail:- ");
		userMail = input.next();
		System.out.println("Enter your password:- ");
		userPassword = input.next();
		currentUser = regestrationController.addUser(userName, userMail, userPassword);
		if(currentUser==null) {
			System.out.println("Sorry, user name or e-mail already used");
			return null;
		}
		System.out.println("Done, user was added successfully!");
		return currentUser;
	}
}
