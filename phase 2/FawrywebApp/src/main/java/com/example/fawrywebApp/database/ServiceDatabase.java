/*package component1;
import java.util.Vector;

public class ServiceDatabase {
	Vector<Service> services = new Vector<Service>();
}*/
package com.example.fawrywebApp.database;
import java.util.Vector;

import com.example.fawrywebApp.model.DonationService;
import com.example.fawrywebApp.model.InternetService;
import com.example.fawrywebApp.model.LandlineService;
import com.example.fawrywebApp.model.MobileService;
import com.example.fawrywebApp.model.Service;

public class ServiceDatabase {
	
	private static ServiceDatabase instance = null;
	//public Vector<User> users;
	public Vector<Service> services = new Vector<Service>();
	private ServiceDatabase() {
		// TODO Auto-generated constructor stub
		//users = new Vector<User>();
		InternetService vodafoneInternet = new InternetService();
		vodafoneInternet.setName("Vodafone Internet");
		vodafoneInternet.setType("Internet Service");
		services.add(vodafoneInternet);
		
		MobileService vodafoneRecharge= new MobileService();
		vodafoneRecharge.setName("Vodafone Recharge");
		vodafoneRecharge.setType("Recharge Service");
		services.add(vodafoneRecharge);
		
		InternetService weInternet = new InternetService();
		weInternet.setName("We Internet");
		weInternet.setType("Internet Service");
		services.add(weInternet); 
		
		MobileService weRecharge= new MobileService();
		weRecharge.setName("We Recharge");
		weRecharge.setType("Recharge Service");
		services.add(weRecharge);
		
		InternetService orangeInternet = new InternetService();
		orangeInternet.setName("Orange Internet");
		orangeInternet.setType("Internet Service");
		services.add(orangeInternet); 
		
		MobileService orangeRecharge = new MobileService();
		orangeRecharge.setName("Orange Recharge");
		orangeRecharge.setType("Recharge Service");
		services.add(orangeRecharge);
		
		InternetService etisalatInternet = new InternetService();
		etisalatInternet.setName("Etisalat Internet");
		etisalatInternet.setType("Internet Service");
		services.add(etisalatInternet);
		
		MobileService etisalatRecharge= new MobileService();
		etisalatRecharge.setName("Etisalat Recharge");
		etisalatRecharge.setType("Recharge Service");
		services.add(etisalatRecharge);
		
		LandlineService landlineService = new LandlineService();
		landlineService.setName("Landline");
		landlineService.setType("Landline Service");
		services.add(landlineService);
		
		DonationService cancerHospital = new DonationService();
		cancerHospital.setName("Cancer Hospital");
		cancerHospital.setType("Donation Service");
		services.add(cancerHospital);
		
		DonationService schools = new DonationService();
		schools.setName("Schools");
		schools.setType("Donation Service");
		services.add(schools);
		
		DonationService NGO = new DonationService();
		NGO.setName("Non profitable organizations");
		NGO.setType("Donation Service");
		services.add(NGO);
	}	
	public static ServiceDatabase  getInstance() {
		if(instance == null) {
			instance = new ServiceDatabase();
		}
		return instance;
	}
	/*public ServiceDatabase() {
		InternetService vodafoneInternet = new InternetService();
		vodafoneInternet.setName("Vodafone Internet");
		services.add(vodafoneInternet);
		MobileService vodafoneRecharge= new MobileService();
		vodafoneInternet.setName("Vodafone Recharge");
		services.add(vodafoneRecharge);
		
		InternetService weInternet = new InternetService();
		weInternet.setName("We Internet");
		services.add(weInternet); 
		MobileService weRecharge= new MobileService();
		weRecharge.setName("We Recharge");
		services.add(weRecharge);
		
		InternetService orangeInternet = new InternetService();
		orangeInternet.setName("Orange Internet");
		services.add(orangeInternet); 
		MobileService orangeRecharge = new MobileService();
		orangeRecharge.setName("Orange Recharge");
		services.add(orangeRecharge);
		
		InternetService etisalatInternet = new InternetService();
		etisalatInternet.setName("Etisalat Internet");
		services.add(etisalatInternet); 
		MobileService etisalatRecharge= new MobileService();
		etisalatRecharge.setName("Etisalat Recharge");
		services.add(etisalatRecharge);
		
		LandlineServices receipt = new LandlineServices();
		receipt.setName("Monthly receipt");
		services.add(receipt);
		receipt.setName("Quarter receipt");
		services.add(receipt);
		
		DonationServices cancerHospital = new DonationServices();
		cancerHospital.setName("Cancer Hospital");
		services.add(cancerHospital);
		DonationServices schools = new DonationServices();
		cancerHospital.setName("Schools");
		services.add(schools);
		DonationServices ngo = new DonationServices();
		cancerHospital.setName("Non profitable organizations");
		services.add(ngo);
				
	}*/

}
