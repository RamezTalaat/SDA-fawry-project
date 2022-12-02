package component1;

public class WalletController extends TransactionController{
	public WalletController(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}
	TransactionDataBase transactionDataBase;
	/*public WalletController (TransactionDataBase transactionDataBase_) {
		transactionDataBase = transactionDataBase_;
	}*/
	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		
		return new AddToWallet();
	}
	@Override
	public Boolean makeTransaction(User user, int amount) {
		// TODO Auto-generated method stub
		if(user.getCreditCard()>=amount) {
			 user.wallet.setAmount(user.wallet.getAmount()+amount);
			 user.setCreditCard(user.getCreditCard()-amount);
			 return true;
		}
		return false;
	}
	/*public boolean addMoneyToWallet(User user,int amount){
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
	}*/

}
