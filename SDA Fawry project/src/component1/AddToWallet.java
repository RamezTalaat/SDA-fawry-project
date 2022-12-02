package component1;

public class AddToWallet extends Transaction{
	Transaction transaction;
	public String type = "Add to wallet" ;
	User user;
	int amount;
	public void setUser (User user_) {
		user = user_;
	}
	public void setAmount(int amount_) {
		amount = amount_;
	}
	public User getUser() {
		return user;
	}
	public int getAmount() {
		return amount;
	}
}
