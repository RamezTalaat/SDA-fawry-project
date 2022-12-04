package component1;

public class DiscountDecorator implements Discount {
	private Discount wrappee;
	protected int amount;
	protected discountType type;
	protected	int minimumTransactions , maximumTransactions;
	protected String service;
	protected String name;
	
	public DiscountDecorator( int _amount) {
		// TODO Auto-generated constructor stub
		wrappee = null;
		amount =_amount;
	}
	public void setWrappee(Discount parent) {
		wrappee = parent;
	}

	@Override
	public int getAmount() { // returns the amount of itself and other discounts
		// TODO Auto-generated method stub
		
		return amount + wrappee.getAmount();
	}
	
}
