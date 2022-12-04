package component1;

public class AddToWallet extends Transaction{
	private Transaction transaction;
	private User user;
	int amount;
	public AddToWallet()
	{
		type=  "walletTransaction";
	}
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
