package com.example.fawrywebApp.controller;

public class DonationFormHandlerFactory implements FormHandlerFactory{

	@Override
	public Form createForm() {
		// TODO Auto-generated method stub
		return new DonationsForm();
	}

	@Override
	public Handler createHandler() {
		// TODO Auto-generated method stub
		return new DonationsHandler();
	}

}
