package component1;

public class EtisalatFactory implements ServiceFactory{

	@Override
	public InternetService createInternetService() {
		return new EtisalatInternetService();
	}

	@Override
	public MobileService createMobileService() {
		return new EtisalatMobileService();
	}

}
