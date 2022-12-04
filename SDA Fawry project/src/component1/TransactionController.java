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
			if(!transaction.type.equals("refundTransaction")) {
				user.transactions.add(transaction);
			}
		}
		return state;
		// if true or false
	}
	public abstract Boolean makeTransaction(User user, int amount , Transaction transaction);  
	public abstract Transaction createTransaction();  // factory method
	public void addTransactionToDatabase(Transaction transaction) {
		transactionDatabase.addTransaction(transaction);
	}
	public void listTransactions() //may have a form to talk to the user
	{
		if(transactionDatabase.transactions.isEmpty()) {
			System.out.println("No transactions yet");
		}
		else {
			for (int i = 0; i < transactionDatabase.transactions.size(); i++) {
				System.out.println("Transaction " + (i+1) +" : ");
				System.out.println("Transaction type: "+transactionDatabase.transactions.get(i).type);
				System.out.println("User Name : " + transactionDatabase.transactions.get(i).getUser().getName());
				if(transactionDatabase.transactions.get(i).type.equals("paymentTransaction")) {
					System.out.println("Service Type : " + transactionDatabase.transactions.get(i).getService().getName());
				}
				System.out.println("Amount : " + transactionDatabase.transactions.get(i).getAmount());
			}
		}
	}
}
