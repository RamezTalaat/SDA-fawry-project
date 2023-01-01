package com.example.fawrywebApp.model;

public class LandlineService extends Service{
	private Receipt receipt;
	public LandlineService()
	{
		setType("LandlineService");
	}
	@Override
	public void setReceipt(Receipt receipt_)
	{
		receipt = receipt_;
	}
	public Receipt getReceipt()
	{
		return receipt;
	}
	@Override
	public Service getClassType() {
		return new LandlineService();
	}
}
