package com.example.fawrywebApp.model;

public class RefundRequest {
	User user;
	private int ID;
	static int idCount=1;
	private Transaction transaction;
	public RefundRequest(User u , Transaction t)
	{
		user = u;
		ID=idCount++;
		transaction = t;
	}
	public void setTransaction(Transaction transaction_)
	{
		transaction = transaction_;
	}
	public void setUser(User user_)
	{
		user = user_;
	}
	public Transaction getTransaction()
	{
		return transaction;
	}
	public User getUser()
	{
		return user;
	}
	public int getID() {
		return ID;
	}
	
}
