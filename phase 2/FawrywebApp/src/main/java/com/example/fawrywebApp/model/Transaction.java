package com.example.fawrywebApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


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
	 public void setService(Service service_)  // Initialize the service with value not reference
	 {
		 service = new Service();
		 service.setForm(service_.getForm());
		 service.setName(service_.getName());
		 service.setType(service_.getType());
		 service.setID(service_.getID());
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





