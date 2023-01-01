package com.example.fawrywebApp.model;

public class LandlineService extends Service{
	public Receipt receipt;
	public LandlineService()
	{
		setType("LandlineService");
	}
	public void setReceipt(Receipt receipt_)
	{
		receipt=receipt_;
	}
}
