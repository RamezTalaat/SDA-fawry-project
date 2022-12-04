package component1;

public class DiscountController {

	DiscountDatabase discountDatabase;
	ServiceDatabase serviceDatabase;
	UsersDatabase usersDatabase;
	
	public void makeDiscount(AddDiscountForm form)
	{
		discountDatabase = DiscountDatabase.getInstance();
		DiscountDecorator discount = new DiscountDecorator(form.amount);
		discount.amount =  form.amount;
		discount.type = form.type;
		discount.minimumTransactions = form.minimumTransactions;
		discount.maximumTransactions = form.maximumTransactions;
		discount.service = form.service;
		discount.name = form.name;
		discountDatabase.addDiscount(discount);//discount added to database
		
		if(discount.type == discountType.overall) {// add to users
			usersDatabase = UsersDatabase.getInstance();
			
			for (int i = 0; i < usersDatabase.users.size(); i++) {// to add discount to users
				int numberOfTransactions = usersDatabase.users.get(i).transactions.size();
				if(numberOfTransactions >= discount.minimumTransactions && numberOfTransactions <= discount.maximumTransactions) {
					discount.setWrappee(usersDatabase.users.get(i).discount); // to make the new discount wrap the old one
					usersDatabase.users.get(i).discount = discount;
				}
			}
		}
		else{// add to services
			for (int i = 0; i < serviceDatabase.services.size(); i++) {// to add discount to users
				Service service = serviceDatabase.services.get(i);
				if(service.name == form.service) {
					discount.setWrappee(service.discount); // to make the new discount wrap the old one
					service.discount = discount;
				}
			}
		}
		
	}
	
	public void getDiscounts()
	{
		discountDatabase = DiscountDatabase.getInstance();
		for (int i = 0; i < discountDatabase.discounts.size(); i++) {
			DiscountDecorator discount = discountDatabase.discounts.get(i);
			System.out.println("Discount name : " + discount.name );
			System.out.println("Discount amount :" + discount.amount + "$" );
		}
	}
}
