package component1;
import java.util.*;



public class FawryInterface {
	static Scanner input = new Scanner(System.in);
	static TransactionDataBase transacionDataBase = TransactionDataBase.getInstance();
	static RegistrationForm registrationForm = new RegistrationForm();
	static WalletForm walletForm = new WalletForm(transacionDataBase);
	static RefundRequestDatabase refundRequestDatabase = RefundRequestDatabase.getInstance();
	static RefundRequestForm refundRequestForm = new RefundRequestForm(refundRequestDatabase);
	static User currentUser = null;
	public static FormHandlerFactory factory;
	public static Form form;
	public static Handler handler;
	public static Service service;
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
		System.out.println("5- List available discounts");
		System.out.println("6- Choose service");
		System.out.println("7- Exit");
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
					DiscountController discountController = new DiscountController();
					discountController.getDiscounts();
					break;
				}
				case 6:{
					payForService();
					break;
				}
				case 7:{
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
	
	private static void payForService() 
	{
		System.out.println("Please choose one of the following services");
		System.out.println("1- Vodafone recharge service");
		System.out.println("2- Etisalat recharge service");
		System.out.println("3- Orange recharge service");
		System.out.println("4- We recharge service");
		System.out.println("5- Vodafone internet service");
		System.out.println("6- Etisalat internet service");
		System.out.println("7- Orange internet service");
		System.out.println("8- We internet service");
		System.out.println("9- Landline service");
		System.out.println("10- Donate for a cancer hospital");
		System.out.println("11- Donate for a school");
		System.out.println("12- Donate for a Non profitable organizations");
		int option = input.nextInt();
		/*if(option >= 1 && option <=4) {
			factory = new MobileFormHandlerFactory();
			form = factory.createForm(transacionDataBase);
			handler = factory.createHandler();
			form.viewForm();
			handler.handleForm(form, currentUser);
		}
		else if(option>=5 && option<=8) {
			factory = new InternetFormHandlerFactory();
			form = factory.createForm(transacionDataBase);
			handler = factory.createHandler();
			form.viewForm();
			handler.handleForm(form, currentUser);
		}
		else if(option == 9) {
			factory = new LandlineFormHandlerFactory();
			form = factory.createForm(transacionDataBase);
			handler = factory.createHandler();
			form.viewForm();
			handler.handleForm(form, currentUser);
		}
		else if(option>= 10 && option<=12) {
			factory = new DonationFormHandlerFactory();
			form = factory.createForm(transacionDataBase);
			handler = factory.createHandler();
			form.viewForm();
			handler.handleForm(form, currentUser);
		}*/
		if(option == 1) {
			service = getService("Vodafone Recharge");
			factory = new MobileFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 2) {
			service = getService("Etisalat Recharge");
			factory = new MobileFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 3) {
			service = getService("Orange Recharge");
			factory = new MobileFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 4) {
			service = getService("We Recharge");
			factory = new MobileFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 5) {
			service = getService("Vodafone Internet");
			factory = new InternetFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 6) {
			service = getService("Etisalat Internet");
			factory = new InternetFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 7) {
			service = getService("Orange Internet");
			factory = new InternetFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 8) {
			service = getService("We Internet");
			factory = new InternetFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 9) {
			service = getService("Landline");
			factory = new LandlineFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 10) {
			service = getService("Cancer Hospital");
			factory = new DonationFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 11) {
			service = getService("Schools");
			factory = new DonationFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else if(option == 12) {
			service = getService("Non profitable organizations");
			factory = new DonationFormHandlerFactory();
			form = factory.createForm();
			handler = factory.createHandler();
			service.setForm(form);
			service.setHandler(handler);
			service.payForService(currentUser);
		}
		else {
			System.out.println("Sorry, invalid option");
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
					AddDiscountForm form = new AddDiscountForm();
					form.getDiscountData();
					DiscountController discountController = new DiscountController();
					discountController.makeDiscount(form);
					break;			
				}
				case 3:{
					TransactionController listerController = new RefundController(transacionDataBase);
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
								refundController.setTransaction(chosenRefundRequest.getUser(), chosenRefundRequest.getTransaction().getAmount(), chosenRefundRequest.getTransaction(), null);
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
	public static Service getService(String serviceName)
	{
		int i=0;
		for(; i<ServiceDatabase.getInstance().services.size(); i++) {
			if(serviceName.equals(ServiceDatabase.getInstance().services.get(i).getName())) {
				break;
			}
		}
		return ServiceDatabase.getInstance().services.get(i);
	}
}











