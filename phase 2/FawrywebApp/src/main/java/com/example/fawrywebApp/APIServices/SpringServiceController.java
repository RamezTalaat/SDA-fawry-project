package com.example.fawrywebApp.APIServices;

import java.util.UUID;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fawrywebApp.controller.DonationFormHandlerFactory;
import com.example.fawrywebApp.controller.DonationsForm;
import com.example.fawrywebApp.controller.DummyForm;
import com.example.fawrywebApp.controller.Form;
import com.example.fawrywebApp.controller.FormHandlerFactory;
import com.example.fawrywebApp.controller.Handler;
import com.example.fawrywebApp.controller.InternetForm;
import com.example.fawrywebApp.controller.InternetFormHandlerFactory;
import com.example.fawrywebApp.controller.LandlineForm;
import com.example.fawrywebApp.controller.LandlineFormHandlerFactory;
import com.example.fawrywebApp.controller.MobileForm;
import com.example.fawrywebApp.controller.MobileFormHandlerFactory;
import com.example.fawrywebApp.controller.SearchController;
import com.example.fawrywebApp.database.ActiveSessions;
import com.example.fawrywebApp.database.ServiceDatabase;
import com.example.fawrywebApp.model.Response;
import com.example.fawrywebApp.model.Service;
import com.example.fawrywebApp.model.User;

@RestController
@RequestMapping("/ServiceController")
public class SpringServiceController {
	@GetMapping("/searchForService/{uuid}/{serviceName}")
	public Response<Vector<Service>> searchForService(@PathVariable ("uuid") UUID uuid ,@PathVariable ("serviceName") String serviceName)
	{
		Response<Vector<Service>> response = new Response<Vector<Service>>();
		if(!ActiveSessions.getInstance().checkSession(uuid)) {
			response.setStatus(false);
			response.setMessage("Sorry, there is no such user");
			return response;
		}
		SearchController searchController = new SearchController();
		Vector<Service> matchingServices = searchController.searchForService(serviceName);
		if(matchingServices.isEmpty()) {
			response.setStatus(false);
			response.setMessage("Sorry, there is no such service");
			return response;
		}
		response.object = matchingServices;
		response.setStatus(true);
		response.setMessage("Matching services was found");
		return response;
	}
	
	@GetMapping("/listServices/{uuid}")
	public Response<Vector<Service>> listServices(@PathVariable ("uuid") UUID uuid)
	{
		Response<Vector<Service>> response = new Response<Vector<Service>>();
		if(!ActiveSessions.getInstance().checkSession(uuid)) {
			response.setStatus(false);
			response.setMessage("Sorry, there is no such user");
			return response;
		}
		response.setStatus(true);
		response.setMessage("Done, services retrived successfully");
		response.object = ServiceDatabase.getInstance().services;
		return response;
	}
	
	@GetMapping("/getServiceForm/{uuid}/{ID}")
	public Response<Form> getServiceForm(@PathVariable ("uuid") UUID uuid, @PathVariable int ID)  // Temp end point to view the values
	{																							  // of the form (not finished)
		Response<Form> response = new Response<Form>();
		if(!ActiveSessions.getInstance().checkSession(uuid)) {
			response.setStatus(false);
			response.setMessage("Sorry, there is no such user");
			return response;
		}
		if(ID > 12 || ID < 1) {
			response.setStatus(false);
			response.setMessage("Sorry, wrong service ID");
			return response;
		}
		if(ID == 1 || ID == 3 || ID == 5 || ID == 7) {
			response.setStatus(true);
			response.setMessage("Done, form retrived successfully!");
			response.object = new InternetForm();
		}
		else if(ID == 2 || ID == 4 || ID == 6 || ID == 8) {
			response.setStatus(true);
			response.setMessage("Done, form retrived successfully!");
			response.object = new MobileForm();
		}
		else if(ID == 9 || ID == 10) {
			response.setStatus(true);
			response.setMessage("Done, form retrived successfully!");
			response.object = new LandlineForm();
		}
		else {
			response.setStatus(true);
			response.setMessage("Done, form retrived successfully!");
			response.object = new DonationsForm();
		}
		return response;
	}
	
	@PostMapping ("/payForService/{uuid}/{ID}")
	public Response payForService(@PathVariable ("uuid") UUID uuid, @PathVariable ("ID") int ID, @RequestBody DummyForm form_)
	{
		Response response = new Response();
		if(!ActiveSessions.getInstance().checkSession(uuid) || ActiveSessions.getInstance().getUser(uuid).getType().equals("Admin")) {
			response.setStatus(false);
			response.setMessage("Sorry, there is no such user");
			return response;
		}
		if(ID > 12 || ID < 1) {
			response.setStatus(false);
			response.setMessage("Sorry, wrong service ID");
			return response;
		}
		Form form;
		Handler handler;
		SearchController searchController = new SearchController();
		Service service;
		FormHandlerFactory factory;
		service = searchController.getService(ID);
		if(ID == 1 || ID == 3 || ID == 5 || ID == 7) {
			factory = new InternetFormHandlerFactory();
		}
		else if(ID == 2 || ID == 4 || ID == 6 || ID ==8) {
			factory = new MobileFormHandlerFactory();
		}
		else if(ID == 9) {
			factory = new LandlineFormHandlerFactory();
		}
		else{
			factory = new DonationFormHandlerFactory();
		}
		form = factory.createForm();
		form.setForm(form_);
		handler = factory.createHandler();
		service.setForm(form);
		service.setHandler(handler);
		service.setReceipt(form.returnReceipt());
		if(!service.payForService((User)ActiveSessions.getInstance().getUser(uuid))) {
			response.setStatus(false);
			response.setMessage("Sorry, you don't have enough money to complete this transaction");
			service.setHandler(null);
			service.setForm(null);
			return response;
		}
		service.setHandler(null);
		service.setForm(null);
		response.setStatus(true);
		response.setMessage("Done, transaction has been completed successfully!");
		return response;
	}
}




