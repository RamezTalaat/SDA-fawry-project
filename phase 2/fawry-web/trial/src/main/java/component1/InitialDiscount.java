package component1;

public class InitialDiscount implements Discount{

	// initial discount returns 0 then it is wrapped by other discounts
	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
