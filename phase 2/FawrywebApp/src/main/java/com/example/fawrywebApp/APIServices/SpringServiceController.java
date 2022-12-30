package com.example.fawrywebApp.APIServices;

import java.util.UUID;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fawrywebApp.controller.SearchController;
import com.example.fawrywebApp.database.ActiveSessions;
import com.example.fawrywebApp.model.Response;
import com.example.fawrywebApp.model.Service;

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
}
