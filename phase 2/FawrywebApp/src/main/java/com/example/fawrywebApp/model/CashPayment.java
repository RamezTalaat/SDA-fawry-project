package com.example.fawrywebApp.model;

import com.example.fawrywebApp.controller.PaymentController;

public class CashPayment extends PaymentController{

	/*public CashPayment(TransactionDataBase _transactionDataBase) {
		super(_transactionDataBase);
		// TODO Auto-generated constructor stub
	}*/

	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		payment.setPaymentType("CashPayment");
		return payment;
	}

	@Override
	public Boolean makeTransaction(User user, int amount, Transaction transaction, Service service) {
		// TODO Auto-generated method stub
		int discount = (service.discount.getAmount() + user.discount.getAmount());
		int price = amount - discount;
		if(price < 0) {
			price = 0;
			discount = amount;
		}
		System.out.println(price+" EGP will be taken from you (cash on delivery)");
		System.out.println("Total discount = " + discount+ " EGP");
		return true;
	}

}
