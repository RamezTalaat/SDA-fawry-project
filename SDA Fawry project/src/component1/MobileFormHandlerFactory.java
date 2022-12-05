package component1;

public class MobileFormHandlerFactory implements FormHandlerFactory{

	@Override
	public Form createForm(TransactionDataBase transactionDataBase) {
		// TODO Auto-generated method stub
		return new MobileForm( transactionDataBase);
	}

	@Override
	public Handler createHandler() {
		// TODO Auto-generated method stub
		return new MobileHandler();
	}

}
