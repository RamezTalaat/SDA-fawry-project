package component1;

import java.util.Vector;

public class DiscountDatabase {
	private static DiscountDatabase instance = null;
	
	private DiscountDatabase() {
		// TODO Auto-generated constructor stub
		
	}	
	public static DiscountDatabase  getInstance() {
		if(instance == null) {
			instance = new DiscountDatabase();
		}
		return instance;
	}
	
	Vector<DiscountDecorator> discounts = new Vector<DiscountDecorator>();
	public void addDiscount(DiscountDecorator discount) {
		discounts.add(discount);
	}
}
