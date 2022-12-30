/*package component1;
enum transactionType
{
	paymentTransaction,
	refundTransaction,
	walletTransaction
}


public abstract class Transaction {
	 User user;
	 int amount;
	 String service;
	 public transactionType type;
	 public void setAmount(int _amount){
		 amount = _amount;
	 }
	 public void setUser(User _user){
		 user = _user;
	 }
	 public int getAmount()
	 {
		 return amount;
	 }
}*/
package com.example.fawrywebApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*enum transactionType
{
	paymentTransaction,
	refundTransaction,
	walletTransaction
}*/


public abstract class Transaction {
	 User user;
	 int amount;
	 Service service;
	 String UserName;
	 String UserMail;
	 private int ID;
	 private static int transactionID = 0;
	 public String type;
	 public Transaction()
	 {
		 ID = ++transactionID;
	 }
	 public void setAmount(int _amount){
		 amount = _amount;
	 }
	 public void setUser(User _user){
		 user = _user;
		 UserName = _user.getName();
		 UserMail = _user.getMail();
	 }
	 public int getAmount()
	 {
		 return amount;
	 }
	 @JsonBackReference
	 public User getUser()
	 {
		 return user;
	 }
	 public void setService(Service service_)
	 {
		 service = service_;
	 }
	 public Service getService()
	 {
		 return service;
	 }
	 public String getUserName() {
		return UserName;
	}
	 public String getUserMail() {
		return UserMail;
	}
	 public void setUserMail(String userMail) {
		UserMail = userMail;
	}
	 public void setUserName(String userName) {
		UserName = userName;
	}
	 public int getID()
	 {
		 return ID;
	 }
}

