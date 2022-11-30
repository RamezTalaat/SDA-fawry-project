package component1;

public class VodafoneFactory implements ServiceFactory{

	@Override
	public InternetService createInternetService() {
		return new VodafoneInternetService();
	}

	@Override
	public MobileService createMobileService() {
		return new VodafoneMobileService();
	}

}
