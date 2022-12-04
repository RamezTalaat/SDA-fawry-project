package component1;

public class CashPayment extends PaymentController{

	public CashPayment(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		payment.setPaymentType("CashPayment");
		return payment;
	}

	@Override
	public Boolean makeTransaction(User user, int amount, Transaction transaction) {
		// TODO Auto-generated method stub
		System.out.println(amount+" EGP will be taken from you (cash on delivery)");
		return true;
	}

}
