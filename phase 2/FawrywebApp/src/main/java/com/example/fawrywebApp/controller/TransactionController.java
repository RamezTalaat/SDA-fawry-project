package com.example.fawrywebApp.controller;
import com.example.fawrywebApp.model.*;

import java.util.Vector;

import com.example.fawrywebApp.database.TransactionDataBase;
public abstract  class TransactionController {
	public TransactionDataBase transactionDatabase = TransactionDataBase.getInstance();
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
	public Vector<Transaction> getTransactions() //may have a form to talk to the user
	{
		
		return TransactionDataBase.getInstance().transactions;
		
	}
	public Transaction getUserTransaction(User user, int ID)
	{
		for(int i=0; i<user.transactions.size(); i++) {
			if(user.transactions.get(i).getID() == ID) {
				return user.transactions.get(i);
			}
		}
		return null;
	}
}

