package component1;

public class WalletPayment extends PaymentController{

	public WalletPayment(TransactionDataBase _transactionDataBase) {
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
	public Boolean makeTransaction(User user, int amount, Transaction transaction) {
		// TODO Auto-generated method stub
		if(user.wallet.getAmount()>=amount) {
			 user.wallet.setAmount(user.wallet.getAmount()-amount);
			 System.out.println("Done! "+amount+" EGP was taken from your wallet");
			 return true;
		}
		System.out.println("Sorry, you don't have enough money in your wallet to make this transaction");
		return false;
	}
}
