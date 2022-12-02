package component1;

public class PaymentController extends TransactionController{
	TransactionDataBase transactionDataBase;
	public PaymentController(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		return new Payment();
	}
	@Override
	public Boolean makeTransaction(User user, int amount, Transaction transaction) {
		// TODO Auto-generated method stub
		
		return null;
	}
	

}
