/*package component1;
enum transactionType
{
	paymentTransaction,
	refundTransaction,
	walletTransaction
}


public abstract class Transaction {
	 User user;
	 int amount;
	 String service;
	 public transactionType type;
	 public void setAmount(int _amount){
		 amount = _amount;
	 }
	 public void setUser(User _user){
		 user = _user;
	 }
	 public int getAmount()
	 {
		 return amount;
	 }
}*/
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
	 public int getAmount()
	 {
		 return amount;
	 }
	 public User getUser()
	 {
		 return user;
	 }
}

