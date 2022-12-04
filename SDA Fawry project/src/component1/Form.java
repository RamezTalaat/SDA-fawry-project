package component1;

public abstract class Form {
	int amount;
	/*public abstract void viewForm();
	public abstract Payment getPaymentMethod(); */
	
	public int getAmount() {
		return amount;
	}
	public abstract void viewForm();
	public abstract Payment getPaymentMethod();
}
