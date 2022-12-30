package com.example.fawrywebApp.controller;

import com.example.fawrywebApp.model.AddToWallet;
import com.example.fawrywebApp.model.Service;
import com.example.fawrywebApp.model.Transaction;
import com.example.fawrywebApp.model.User;

public class WalletController extends TransactionController{
	/*public WalletController(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
	}*/
	//TransactionDataBase transactionDataBase;
	/*public WalletController (TransactionDataBase transactionDataBase_) {
		transactionDataBase = transactionDataBase_;
	}*/
	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		
		return new AddToWallet();
	}
	@Override
	public Boolean makeTransaction(User user, int amount , Transaction transaction, Service serivce) {
		// TODO Auto-generated method stub
		if(user.getCreditCard()>=amount) {
			 int tmpAmount = user.getWallet().getAmount()+amount;
			 user.getWallet().setAmount(tmpAmount);
			 user.setCreditCard(user.getCreditCard()-amount);
			 return true;
		}
		return false;
	}
}
