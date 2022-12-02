package component1;

public abstract class Transaction {
	 User user;
	 int amount;
	 String service;
	
	 public void setAmount(int _amount){
		 amount = _amount;
	 }
	 public void setUser(User _user){
		 user = _user;
	 }
}
