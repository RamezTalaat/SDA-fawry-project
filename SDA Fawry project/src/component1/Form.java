package component1;

public abstract class Form {
	private int amount;
	//public PaymentController paymentMethod;
	//public TransactionDataBase transactionDataBase;
	/*public abstract void viewForm();
	public abstract Payment getPaymentMethod(); */
	public Form() {
		//transactionDataBase = TransactionDataBase.getInstance(); 
		//paymentMethod = new CreditCardPayment(transactionDataBase);
	}
	public void setAmount(int amount_)
	{
		amount = amount_;
	}
	public int getAmount() {
		return amount;
	}
	public abstract void viewForm();
	public abstract PaymentController getPaymentMethod();
	public abstract void getForm();
}
