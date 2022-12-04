package component1;

import java.util.Vector;

public class DiscountDatabase {
	Vector<Discount> discounts = new Vector<Discount>();
	public void addDiscount(Discount discount) {
		discounts.add(discount);
	}
}
