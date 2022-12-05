package component1;

import java.util.Vector;

public class DiscountDatabase {
	private static DiscountDatabase instance = null;
	Vector<DiscountDecorator> discounts = new Vector<DiscountDecorator>();
	private DiscountDatabase() {
		// TODO Auto-generated constructor stub
		
	}	
	public static DiscountDatabase  getInstance() {
		if(instance == null) {
			instance = new DiscountDatabase();
		}
		return instance;
	}
	
	public void addDiscount(DiscountDecorator discount) {
		discounts.add(discount);
	}
}
