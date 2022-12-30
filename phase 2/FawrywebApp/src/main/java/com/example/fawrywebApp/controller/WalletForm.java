package com.example.fawrywebApp.controller;
import java.util.*;

import com.example.fawrywebApp.model.User;

public class WalletForm {
	Scanner input = new Scanner(System.in);
	WalletController walletController;
	public  WalletForm() {
		walletController =new WalletController();
	}
  public void getWalletForm (User user) {
	  System.out.print("Enter the amount of money you want to add ");
	  int amount;
	  amount=input.nextInt();
	  if ( walletController.setTransaction(user , amount, null, null)) {
		 System.out.println("Wallet is updated succefuly");
		 System.out.println("Your wallet balance = "+user.wallet.getAmount()+" EGP");
	 }
	 else {
		 System.out.println("There is no enough money");
	 }
	  
	  }
}
