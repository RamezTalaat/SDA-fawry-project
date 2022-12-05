package component1;

public class DonationFormHandlerFactory implements FormHandlerFactory{

	@Override
	public Form createForm(TransactionDataBase transactionDataBase) {
		// TODO Auto-generated method stub
		return new DonationsForm( transactionDataBase);
	}

	@Override
	public Handler createHandler() {
		// TODO Auto-generated method stub
		return new DonationsHandler();
	}

}
