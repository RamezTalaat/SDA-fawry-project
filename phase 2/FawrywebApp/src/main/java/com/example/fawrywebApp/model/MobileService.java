package com.example.fawrywebApp.model;

public class MobileService extends Service{
	public MobileService()
	{
		setType("MobileService");
	}

	@Override
	public Service getClassType() {
		return new MobileService();
	}
}
