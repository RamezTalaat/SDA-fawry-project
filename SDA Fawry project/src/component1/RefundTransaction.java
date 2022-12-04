package component1;

public class RefundTransaction extends Transaction{
	Transaction transaction;
	//Service	service;
	public RefundTransaction()
	{
		type = "refundTransaction";
	}
}
