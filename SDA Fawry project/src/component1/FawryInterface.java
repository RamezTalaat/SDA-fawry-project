package component1;
import java.util.*;



public class FawryInterface {
	static Scanner input = new Scanner(System.in);
	static TransactionDataBase transacionDataBase = new TransactionDataBase();
	static RegistrationForm registrationForm = new RegistrationForm();
	static WalletForm walletForm = new WalletForm(transacionDataBase);
	static RefundRequestDatabase refundRequestDatabase = new RefundRequestDatabase();
	static RefundRequestForm refundRequestForm = new RefundRequestForm(refundRequestDatabase);
	static User currentUser = null;
	public static void main(String[] args) {
		Admin admin  = new Admin();
		admin.setName("admin");
	    admin.setPassword("admin");
		admin.setMail("admin@gmail.com");
		// Admin name: "admin", Admin password: "admin", Admin mail: "admin@gmail.com"
		// The system users can't create new admins at run time, admins can be created only at code time (purposely)
		System.out.println("Welcome to our fawry system!");
		int option = 0;
		while(currentUser == null) {
			System.out.println("1- Sign in");
			System.out.println("2- Sign up");
			System.out.println("3- Enter as admin");
			System.out.println("4- Exit");
			option = input.nextInt();
			if(option == 1) {
				currentUser = registrationForm.signIn();
			}
			else if(option == 2) {
				currentUser = registrationForm.signUp();
			}
			else if(option == 3) {
				System.out.println("Enter your mail:- ");
				String mail = input.next();
				System.out.println("Enter your password:- ");
				String password = input.next();
				if(password.equals(admin.getPassword()) && mail.equals(admin.getMail())) {
					System.out.println("Done, admin has logged in!");
					getAdminMenu();
				}
				else {
					System.out.println("Sorry, can't log you in as admin (Wrong mail or password)");
				}
			}
			else if(option == 4) {
				return;
			}
			else {
				System.out.println("Sorry, invalid option");
			}
			if(currentUser != null) {
				getUserMenu();
			}
		}
	}
	public static void getUserMenu()
	{
		System.out.println("Please choose one of the following options:-");
		System.out.println("1- Print current user information");
		System.out.println("2- Log out");
		System.out.println("3- Add money to your wallet");
		System.out.println("4- Request a refund for a completed transaction");
		System.out.println("5- Exit");
		System.out.println("Option:- ");
		int option = 0;
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
					return;
				}
				case 3:{
					walletForm.getWalletForm(currentUser);
					break;
				}
				case 4:{
					refundRequestForm.getRefundRequestForm(currentUser);
					break;
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
	public static void getAdminMenu()
	{
		System.out.println("Please choose one of the following options:-");
		System.out.println("1- Log out");
		System.out.println("2- Add discount");
		System.out.println("3- List user transactions");
		System.out.println("4- List refund requests");
		System.out.println("Option:- ");
		int option;
		while(true) {
			option = input.nextInt();
			switch(option){
				case 1:{
					return;
				}
				case 2:{
					
					break;			
				}
				case 3:{
					TransactionController listerController = new PaymentController(transacionDataBase);
					listerController.listTransactions();
					break;					
				}
				case 4:{
					RefundRequestController refundRequestController = new RefundRequestController(refundRequestDatabase);
					refundRequestController.listRefundRequests();
					if(refundRequestDatabase.refundRequests.size()==0) {
						break;
					}
					System.out.println("Do you want to approve or reject a Request? (answer with 'yes' or 'no')");
					String answer = input.next();
					if(answer.equals("yes")) {
						System.out.println("Please choose the number of the request");
						int choice = input.nextInt();
						if(choice>refundRequestController.refundRequestDatabase.refundRequests.size()) {
							System.out.println("Sorry, invalid option");
						}
						else {
							RefundRequest chosenRefundRequest = refundRequestDatabase.refundRequests.get(choice-1);
							System.out.println("Do you want to approve or reject this transaction? (answer with 'approve' or 'reject')");
							answer = input.next();
							refundRequestController.removeRequest(chosenRefundRequest, answer);
							if(answer.equals("approve")) {
								RefundController refundController = new RefundController(transacionDataBase);
								refundController.setTransaction(chosenRefundRequest.getUser(), chosenRefundRequest.getTransaction().getAmount(), chosenRefundRequest.getTransaction());
								System.out.println("Request has been approved successfully");
							}
							else {
								System.out.println("Request has been rejected successfully");
							}
						}
					}
					else if(!answer.equals("no")) {
						System.out.println("Sorry, invalid option");
					}
					break;
				}
				default:{
					System.out.println("Sorry, invalid option");
				}
			}
			System.out.println("Choose another option:- ");
		}		
	}
}

