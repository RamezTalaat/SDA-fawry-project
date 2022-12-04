package component1;

public class WalletPayment extends PaymentController{

	public WalletPayment(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		return new Payment();
	}

}
