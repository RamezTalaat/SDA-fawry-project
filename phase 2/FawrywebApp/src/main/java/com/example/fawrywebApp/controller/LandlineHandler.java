package com.example.fawrywebApp.controller;

import com.example.fawrywebApp.model.Service;
import com.example.fawrywebApp.model.User;

public class LandlineHandler implements Handler {

	@Override
	public boolean handleForm(Form form,  User user,  Service service) {
		// TODO Auto-generated method stub
		PaymentController paymentController = form.returnPaymentMethod();
		return paymentController.setTransaction(user, form.getAmount(), null, service);
	}
}
