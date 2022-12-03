package component1;
import java.util.*;

public class WalletForm {
	Scanner input = new Scanner(System.in);
	WalletController walletController;
	public  WalletForm(TransactionDataBase transactionDataBase_) {
		walletController =new WalletController(transactionDataBase_);
	}
  public void getWalletForm (User user) {
	  System.out.print("Enter the amount of money you want to add ");
	  int amount;
	  amount=input.nextInt();
	  if ( walletController.setTransaction(user , amount, null)) {
		 System.out.println("Wallet is updated succefuly");
		 System.out.println("Your wallet balance = "+user.wallet.getAmount()+" EGP");
	 }
	 else {
		 System.out.println("There is no enough money");
	 }
	  
	  }
}
