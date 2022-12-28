package com.example.fawrywebApp.model;
import java.util.Random;
import java.util.Vector;

public class User {
    private String name;
    private String password;
    private String mail;
    private int creditCard;
    int ID;
    static int idCount = 1;
    public Discount discount;
    public Vector<Transaction> transactions;
    Random random = new Random();
    Wallet wallet ;
    public User()
    {
        ID = idCount++;
        wallet = new Wallet();
        creditCard = random.nextInt(1000, 10000); // Generates random amount of money in the user's credit card between 1000 EGP and 10000 EGP
        transactions = new Vector<Transaction>();
        discount = new InitialDiscount();
    }
    public void setName(String name_)
    {
    	name = name_;
    }
    public void setPassword(String password_)
    {
    	password = password_;
    }
    public void setMail(String mail_)
    {
    	mail = mail_;
    }
    public void setCreditCard(int creditCard_)
    {
    	creditCard=creditCard_;
    }
    public String getName()
    {
    	return name;
    }
    public String getPassword()
    {
    	return password;
    }
    public String getMail()
    {
    	return mail;
    }
    public int getCreditCard()
    {
    	return creditCard;
    }

    public Wallet getWallet() {
        return wallet;
    }
}
