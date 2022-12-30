package com.example.fawrywebApp.controller;
import java.util.Scanner;

import com.example.fawrywebApp.model.User;

public class RefundRequestForm {
	Scanner input = new Scanner(System.in);
	RefundRequestController refundRequestController;
	public RefundRequestForm()
	{
		refundRequestController = new RefundRequestController();
	}
	public void getRefundRequestForm(User user)
	{
		if(user.transactions.size()==0) {
			System.out.println("Sorry, no transactions to be refunded");
			return;
		}
		System.out.println("Please choose the transaction you want to issue a refund request for:- ");
		for(int i=0; i<user.transactions.size(); i++) {
			if(user.transactions.get(i).type.equals("paymentTransaction")) {
				System.out.println((i+1)+"- Transaction type: " + user.transactions.get(i).type+ ", trasaction amount: " + user.transactions.get(i).getAmount() + " EGP ,service name: " + user.transactions.get(i).getService().getName() + " ,service type: " + user.transactions.get(i).getService().getType());
			}
			else {
				System.out.println((i+1)+"- Transaction type: " + user.transactions.get(i).type+ ", trasaction amount " + user.transactions.get(i).getAmount()+" EGP");
			}
		}
		int option = input.nextInt();
		if(refundRequestController.validateOption(option, user)) {
			if(refundRequestController.checkTransactionExistence(option, user)) {
				System.out.println("Sorry, a refund request has been already issued for the choosen transaction");
				return;
			}
			refundRequestController.makeRefundRequest(option, user);
			System.out.println("Done! A refund request has been issued for the chosen transaction");
		}
		else {
			System.out.println("Sorry, invalid option");
		}
	}
}
