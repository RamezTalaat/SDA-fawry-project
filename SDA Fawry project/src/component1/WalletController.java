package component1;

public class WalletController {
	TransactionDataBase transactionDataBase;
	public WalletController (TransactionDataBase transactionDataBase_) {
		transactionDataBase = transactionDataBase_;
	}
	public boolean addMoneyToWallet(User user,int amount){
		if(user.getCreditCard()>=amount) {
			 user.wallet.setAmount(user.wallet.getAmount()+amount);
			 user.setCreditCard(user.getCreditCard()-amount);
			 AddToWallet addToWalletTransaction = new AddToWallet();
			 addToWalletTransaction.setAmount(amount);
			 addToWalletTransaction.setUser(user);
			
			transactionDataBase.transactions.add(addToWalletTransaction);
			 return true;
		}
	    return false;
	}

}
