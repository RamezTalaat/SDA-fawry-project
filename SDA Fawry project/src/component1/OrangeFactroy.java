package component1;

public class OrangeFactroy implements ServiceFactory{

	@Override
	public InternetService createInternetService() {
		return new OrangeInternetService();
	}

	@Override
	public MobileService createMobileService() {
		return new OrangeMobileService();
	}

}
