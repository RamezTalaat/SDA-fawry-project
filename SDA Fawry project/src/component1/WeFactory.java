package component1;

public class WeFactory implements ServiceFactory{

	@Override
	public InternetService createInternetService() {
		return new WeInternetService();
	}

	@Override
	public MobileService createMobileService() {
		return new WeMobileService();
	}

}
