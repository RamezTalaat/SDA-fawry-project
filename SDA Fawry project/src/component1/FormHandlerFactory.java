package component1;

public interface FormHandlerFactory {
	public Form createForm(TransactionDataBase transactionDataBase);
	public Handler createHandler();
}
