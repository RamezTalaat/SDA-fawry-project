package component1;

public class CreditCardPayment extends PaymentController{

	public CreditCardPayment(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		payment.setPaymentType("WalletPayment");
		return payment;
	}

	@Override
	public Boolean makeTransaction(User user, int amount, Transaction transaction) 
	{
		// TODO Auto-generated method stub
		if(user.getCreditCard()>=amount) {
			 user.setCreditCard(user.getCreditCard()-amount);
			 System.out.println(amount+" EGP was taken from your credit card");
			 return true;
		}
		return false;
	}

}
