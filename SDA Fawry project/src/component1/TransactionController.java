package component1;

public abstract  class TransactionController {
	TransactionDataBase transactionDatabase;
	public TransactionController (TransactionDataBase _transactionDataBase) {
		transactionDatabase = _transactionDataBase;
	}
	public Boolean setTransaction(User user, int amount , Transaction _transaction) {
		Boolean state =makeTransaction(user,amount,_transaction);
		if (state) {
			Transaction transaction = createTransaction();
			transaction.setAmount(amount);
			transaction.setUser(user);
			addTransactionToDatabase(transaction);
		}			
		return state;
		// if true or false
		
	}
	public abstract Boolean makeTransaction(User user, int amount , Transaction transaction);  
	public abstract Transaction createTransaction();  
	public void addTransactionToDatabase(Transaction transaction) {
		transactionDatabase.addTransaction(transaction);
	}
	public void listTransactions() //may have a form to talk to the user
	{
		if(transactionDatabase.transactions.isEmpty()) {
			System.out.println("No avialable transactions yet");
			
		}
		else {
			for (int i = 0; i < transactionDatabase.transactions.size(); i++) {
				System.out.println("Transaction " + i+1 +" : ");
				System.out.println("User Name : " + transactionDatabase.transactions.get(i).user.getName());
				System.out.println("Service Type : " + transactionDatabase.transactions.get(i).service.getName());
				System.out.println("Amount : " + transactionDatabase.transactions.get(i).amount);
			}
		}
		
	}
}
