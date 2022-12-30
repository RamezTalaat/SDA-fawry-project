package com.example.fawrywebApp.controller;

import com.example.fawrywebApp.model.Service;
import com.example.fawrywebApp.model.User;

public interface Handler {

	public void handleForm(Form form,  User user,  Service service); // Every handler should handle the Form depending on the purpose of the form but in this system
	// the handler will only use the amount
	
}
