package com.example.fawrywebApp.controller;

import com.example.fawrywebApp.model.Service;
import com.example.fawrywebApp.model.User;

public class DonationsHandler implements Handler{

	@Override
	public boolean handleForm(Form form, User user,  Service service) {
		PaymentController paymentController = form.returnPaymentMethod();
		return paymentController.setTransaction(user, form.getAmount(), null, service);
	}
}
