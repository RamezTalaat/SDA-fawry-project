package com.example.fawrywebApp.model;

public class InternetService extends Service{
	public InternetService()
	{
		setType("InternetService");
	}

	@Override
	public Service getClassType() {
		return new InternetService();
	}
}
