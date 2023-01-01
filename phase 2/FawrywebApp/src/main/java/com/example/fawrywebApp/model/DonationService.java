package com.example.fawrywebApp.model;

public class DonationService extends Service{
	public DonationService()
	{
		setType("DonationService");
	}

	@Override
	public Service getClassType() {
		return new DonationService();
	}
}
