package component1;



public class RefundController extends TransactionController{
	/*public RefundController(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}*/
	

	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		return  new RefundTransaction();
	}
	@Override
	public Boolean makeTransaction(User user, int amount ,Transaction transaction, Service service) {
		// TODO Auto-generated method stub
		Boolean state  = true;
		//
		if(transaction.type.equals("walletTransaction")) {
			user.setCreditCard(user.getCreditCard()+amount);
			user.wallet.setAmount(user.wallet.getAmount()-amount);
		}
		else {
			user.wallet.setAmount(user.wallet.getAmount()+amount);
		}
		/*for (int i = 0; i < transactionDataBase.transactions.size(); i++) {
			if(transactionDataBase.transactions.get(i) == transaction)
			{
				transactionDataBase.transactions.remove(i);       //to remove the deleted transaction from transactions database
				state = true;
			}
		}*/
		return state;
	}
}
