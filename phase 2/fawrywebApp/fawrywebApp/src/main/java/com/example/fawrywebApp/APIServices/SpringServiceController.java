package com.example.fawrywebApp.APIServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fawrywebApp.model.Response;

@RestController
@RequestMapping("/ServiceController")
public class SpringServiceController {
	@GetMapping("/searchForService")
	public Response<String> searchForService(@PathVariable String serviceName)
	{
		Response<String> response = new Response<String>();
		return response;
	}
}
