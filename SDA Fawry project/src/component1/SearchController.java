package component1;

import java.util.Scanner;
import java.util.Vector;

public class SearchController {
	
	private ServiceDatabase serviceDatabase ; 
	private Vector<Service> searchedServices;
	public SearchController() {
		// TODO Auto-generated constructor stub
		serviceDatabase = ServiceDatabase.getInstance();
		searchedServices = new Vector<Service>();
	}
	
	public void searchForService() {
		Scanner input = new Scanner(System.in);
		ServiceDatabase serviceDatabase = ServiceDatabase.getInstance();
		Vector<Service> searchedServices = new Vector<Service>();
		String searchedService;
		
		System.out.println("Enter service name to search");
		//input.nextLine();   // to clear buffer from /n after nextInt() input
		searchedService = input.nextLine();
			for (int j = 0; j < serviceDatabase.services.size(); j++) {
				
				Service service = serviceDatabase.services.get(j);
				String serviceName = service.getName();
				int firstIdx =-1;
				for (int k = 0; k < serviceName.length(); k++) {
					Boolean state = true;
					if(searchedService.toLowerCase().charAt(0) == serviceName.toLowerCase().charAt(k)) {

						firstIdx =k;  //to get the first matching character
						if( (serviceName.length()-firstIdx)>= searchedService.length() ) { // to check if characters matched and
							
							for (int z = 0; z < searchedService.length() ; z++) { // to check if each character is the same
								if(searchedService.toLowerCase().charAt(z) != serviceName.toLowerCase().charAt(z+firstIdx)) {
									
									state = false;
									break; // to exit loop
								}
														
							}
							if(state) { // to check if the service name matched the search
				
								Boolean serviceState = true;
								for (int f = 0; f < searchedServices.size(); f++) { // to check if this service was added before
									if(searchedServices.get(f) == service) {
										serviceState = false;
										break;
									}
									
								}
								if(serviceState) {
									searchedServices.add(service);
								}
								
							}
						}
					}
				}
						
			}
			
		if(searchedServices.isEmpty()) {
			System.out.println("No corresponding services were found");
		}
		else {
			for (int i = 0; i < searchedServices.size(); i++) {
				System.out.println(i+1 + "- " + searchedServices.get(i).name + "	Type: " +searchedServices.get(i).type );
			}
		}
	}
	
}
