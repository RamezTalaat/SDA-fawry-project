package component1;

public class LandlineFormHandlerFactory implements FormHandlerFactory{

	@Override
	public Form createForm(TransactionDataBase transactionDataBase) {
		// TODO Auto-generated method stub
		return new LandlineForm( transactionDataBase);
	}

	@Override
	public Handler createHandler() {
		// TODO Auto-generated method stub
		return new LandlineHandler();
	}
	
}
