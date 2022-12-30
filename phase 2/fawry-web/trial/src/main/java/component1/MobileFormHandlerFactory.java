package component1;

public class MobileFormHandlerFactory implements FormHandlerFactory{

	@Override
	public Form createForm() {
		// TODO Auto-generated method stub
		return new MobileForm();
	}

	@Override
	public Handler createHandler() {
		// TODO Auto-generated method stub
		return new MobileHandler();
	}

}
