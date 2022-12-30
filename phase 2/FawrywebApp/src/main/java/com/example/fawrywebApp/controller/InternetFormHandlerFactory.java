package com.example.fawrywebApp.controller;

public class InternetFormHandlerFactory implements FormHandlerFactory{

	@Override
	public Form createForm() {
		// TODO Auto-generated method stub
		return new InternetForm();
	}

	@Override
	public Handler createHandler() {
		// TODO Auto-generated method stub
		return new InternetHandler();
	}

}
