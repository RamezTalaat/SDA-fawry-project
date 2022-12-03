package component1;
enum transactionType
{
	paymentTransaction,
	refundTransaction,
	walletTransaction
}


public abstract class Transaction {
	 User user;
	 int amount;
	 Service service;
	 transactionType type;
	
	 public void setAmount(int _amount){
		 amount = _amount;
	 }
	 public void setUser(User _user){
		 user = _user;
	 }
}
