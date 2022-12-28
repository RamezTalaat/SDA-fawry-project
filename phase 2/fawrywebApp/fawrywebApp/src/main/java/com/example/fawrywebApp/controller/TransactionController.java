package com.example.fawrywebApp.controller;
import com.example.fawrywebApp.model.*;
import com.example.fawrywebApp.database.TransactionDataBase;
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
	}
}

