package component1;

public class RefundRequest {
	User user;
	Transaction transaction;
	public RefundRequest(User u , Transaction t)
	{
		user = u;
		transaction = t;
	}
}
