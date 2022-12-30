package component1;

public abstract class PaymentController extends TransactionController{
	/*public PaymentController(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}*/

	@Override
	public abstract Transaction createTransaction();
	@Override
	public abstract Boolean makeTransaction(User user, int amount, Transaction transaction, Service service);
		// TODO Auto-generated method stub
	

}
