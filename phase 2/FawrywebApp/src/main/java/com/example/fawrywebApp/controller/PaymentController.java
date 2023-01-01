package com.example.fawrywebApp.controller;
import com.example.fawrywebApp.model.*;

public abstract class PaymentController extends TransactionController{

	@Override
	public abstract Transaction createTransaction();
	@Override
	public abstract Boolean makeTransaction(User user, int amount, Transaction transaction, Service service);
		// TODO Auto-generated method stub
	

}
