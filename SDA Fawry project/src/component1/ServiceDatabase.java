package component1;
import java.util.Vector;

public class ServiceDatabase {
	Vector<Service> services = new Vector<Service>();
	public ServiceDatabase() {
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
				
	}

}
