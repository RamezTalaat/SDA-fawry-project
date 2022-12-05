package component1;

public class InternetFormHandlerFactory implements FormHandlerFactory{

	@Override
	public Form createForm(TransactionDataBase transactionDataBase) {
		// TODO Auto-generated method stub
		return new InternetForm(transactionDataBase);
	}

	@Override
	public Handler createHandler() {
		// TODO Auto-generated method stub
		return new InternetHandler();
	}

}
