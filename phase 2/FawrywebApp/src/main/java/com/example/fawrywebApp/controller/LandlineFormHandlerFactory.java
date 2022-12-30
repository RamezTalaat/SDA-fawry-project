package com.example.fawrywebApp.controller;

public class LandlineFormHandlerFactory implements FormHandlerFactory{

	@Override
	public Form createForm() {
		// TODO Auto-generated method stub
		return new LandlineForm();
	}

	@Override
	public Handler createHandler() {
		// TODO Auto-generated method stub
		return new LandlineHandler();
	}
	
}
