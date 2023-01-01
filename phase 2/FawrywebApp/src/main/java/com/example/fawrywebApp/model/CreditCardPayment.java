package com.example.fawrywebApp.model;

import com.example.fawrywebApp.controller.PaymentController;

public class CreditCardPayment extends PaymentController{

	/*public CreditCardPayment(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}*/

	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		payment.setPaymentType("CreditCardPayment");
		return payment;
	}

	@Override
	public Boolean makeTransaction(User user, int amount, Transaction transaction, Service service)
	{
		// TODO Auto-generated method stub
		int discount = (service.discount.getAmount() + user.discount.getAmount());
		int price = amount - discount;
		if(price < 0) {
			price = 0;
			discount = amount;
		}
		if(user.getCreditCard()>=price) {
			 user.setCreditCard(user.getCreditCard()-price);
			 System.out.println("Done! "+price+" EGP was taken from your credit card");
			 System.out.println("Total discount = "+ discount+" EGP");
			 return true;
		}
		System.out.println("Sorry, you don't have enough money in your creditcard to make this transaction");
		return false;
	}

}
