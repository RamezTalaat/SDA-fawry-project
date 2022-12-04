package component1;

public abstract class PaymentController extends TransactionController{
	TransactionDataBase transactionDataBase;
	public PaymentController(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Transaction createTransaction();
	@Override
	public Boolean makeTransaction(User user, int amount, Transaction transaction) {
		// TODO Auto-generated method stub
		
		return null;
	}
	

}
