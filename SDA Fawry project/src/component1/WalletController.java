package component1;

public class WalletController extends TransactionController{
	public WalletController(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
	}
	//TransactionDataBase transactionDataBase;
	/*public WalletController (TransactionDataBase transactionDataBase_) {
		transactionDataBase = transactionDataBase_;
	}*/
	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		
		return new AddToWallet();
	}
	@Override
	public Boolean makeTransaction(User user, int amount , Transaction transaction) {
		// TODO Auto-generated method stub
		if(user.getCreditCard()>=amount) {
			 user.wallet.setAmount(user.wallet.getAmount()+amount);
			 user.setCreditCard(user.getCreditCard()-amount);
			 return true;
		}
		return false;
	}
	

}
