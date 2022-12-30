package component1;

public abstract  class TransactionController {
	public TransactionDataBase transactionDatabase = TransactionDataBase.getInstance();
	/*public TransactionController (TransactionDataBase _transactionDataBase) {
		transactionDatabase = _transactionDataBase;
	}*/
	public Boolean setTransaction(User user, int amount , Transaction _transaction, Service service) { 
		Boolean state =makeTransaction(user, amount, _transaction, service); ////////////
		if (state) {
			Transaction transaction = createTransaction();
			transaction.setAmount(amount);
			transaction.setUser(user);
			transaction.setUserName(user.getName());
			transaction.setUserMail(user.getMail());
			if(transaction.type.equals("paymentTransaction")) {
				transaction.setService(service);
			}
			addTransactionToDatabase(transaction);
			if(!transaction.type.equals("refundTransaction")) {
				user.transactions.add(transaction);
			}
		}
		return state;
		// if true or false
	}
	public abstract Boolean makeTransaction(User user, int amount , Transaction transaction, Service service);  
	public abstract Transaction createTransaction();  // factory method
	public void addTransactionToDatabase(Transaction transaction) {
		transactionDatabase.addTransaction(transaction);
	}
	public void listTransactions() //may have a form to talk to the user
	{
<<<<<<< HEAD:phase 2/fawrywebApp/fawrywebApp/src/main/java/com/example/fawrywebApp/controller/TransactionController.java
		
		return TransactionDataBase.getInstance().transactions;
		
=======
		if(transactionDatabase.transactions.isEmpty()) {
			System.out.println("No transactions yet");
		}
		else {
			for (int i = 0; i < transactionDatabase.transactions.size(); i++) {
				System.out.println("Transaction " + (i+1) +" : ");
				System.out.println("Transaction type: "+transactionDatabase.transactions.get(i).type);
				System.out.println("User Name : " + transactionDatabase.transactions.get(i).getUser().getName());
				if(transactionDatabase.transactions.get(i).type.equals("paymentTransaction")) {
					System.out.println("Service Name : " + transactionDatabase.transactions.get(i).getService().getName());
					System.out.println("Service Type : " + transactionDatabase.transactions.get(i).getService().getType());
				}
				System.out.println("Amount : " + transactionDatabase.transactions.get(i).getAmount());
			}
		}
>>>>>>> c3ed8acdf1e8c4e39a6f2861c2b65f18ad38b210:phase 2/fawry-web/trial/src/main/java/component1/TransactionController.java
	}
}

