package component1;

public abstract  class TransactionController {
	TransactionDataBase transactionDatabase;
	public TransactionController (TransactionDataBase _transactionDataBase) {
		transactionDatabase = _transactionDataBase;
	}
	public Boolean setTransaction(User user, int amount) {
		Boolean state =makeTransaction(user,amount);
		if (state) {
			Transaction transaction = createTransaction();
			transaction.setAmount(amount);
			transaction.setUser(user);
			addTransactionToDatabase(transaction);
		}
		return state;
		// if true or false
		
	}
	public abstract Boolean makeTransaction(User user, int amount);  
	public abstract Transaction createTransaction();  
	public void addTransactionToDatabase(Transaction transaction) {
		transactionDatabase.addTransaction(transaction);
	}
}
