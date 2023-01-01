package com.example.fawrywebApp.model;

import com.example.fawrywebApp.controller.PaymentController;

public class WalletPayment extends PaymentController{

	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		payment.setPaymentType("WalletPayment");
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
		if(user.wallet.getAmount()>=price) {
			 user.wallet.setAmount(user.wallet.getAmount()-price);
			 System.out.println("Done! "+price+" EGP was taken from your wallet");
			 System.out.println("Total discount = "+ discount+ " EGP");
			 return true;
		}
		System.out.println("Sorry, you don't have enough money in your wallet to make this transaction");
		return false;
	}
}
