package com.example.fawrywebApp.model;

public class Admin implements IGeneralUser {
	private String name;
    private String password;
    private String mail;
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
}
