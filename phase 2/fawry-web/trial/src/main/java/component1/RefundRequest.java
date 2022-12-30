package component1;

public class RefundRequest {
	User user;
	Transaction transaction;
	public RefundRequest(User u , Transaction t)
	{
		user = u;
		transaction = t;
	}
	public void setTransaction(Transaction transaction_)
	{
		transaction = transaction_;
	}
	public void setUser(User user_)
	{
		user = user_;
	}
	public Transaction getTransaction()
	{
		return transaction;
	}
	public User getUser()
	{
		return user;
	}
}
