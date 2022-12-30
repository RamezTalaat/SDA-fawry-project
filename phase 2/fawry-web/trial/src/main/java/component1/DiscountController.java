package component1;

public class DiscountController {

	DiscountDatabase discountDatabase = DiscountDatabase.getInstance();
	ServiceDatabase serviceDatabase = ServiceDatabase.getInstance();
	UsersDatabase usersDatabase = UsersDatabase.getInstance();
	
	public void makeDiscount(AddDiscountForm form)
	{
		DiscountDecorator discount = new DiscountDecorator(form.amount);
		discount.amount =  form.amount;
		discount.type = form.type;
		discount.minimumTransactions = form.minimumTransactions;
		discount.maximumTransactions = form.maximumTransactions;
		discount.service = form.service;
		discount.name = form.name;
		discountDatabase.addDiscount(discount);//discount added to database
		
		if(discount.type == discountType.overall) { // add to users
			for (int i = 0; i < usersDatabase.users.size(); i++) {// to add discount to users
				int numberOfTransactions = usersDatabase.users.get(i).transactions.size();
				if(numberOfTransactions >= discount.minimumTransactions && numberOfTransactions <= discount.maximumTransactions) {
					discount.setWrappee(usersDatabase.users.get(i).discount); // to make the new discount wrap the old one
					usersDatabase.users.get(i).discount = discount;
				}
			}
		}
		else{ // add to services
			for (int i = 0; i < serviceDatabase.services.size(); i++) {// to add discount to users
				//Service service = serviceDatabase.services.get(i);
				//System.out.println("heeeeeeeeeeeeeeeeey");
				if(serviceDatabase.services.get(i).getName().equals(discount.service)) {
					discount.setWrappee(serviceDatabase.services.get(i).discount); // to make the new discount wrap the old one
					serviceDatabase.services.get(i).discount = discount;
					//service.discount = discount;
					//service.discount.getAmount();
					break;
				}
			}
		}
		
	}
	
	public void getDiscounts()
	{
		for (int i = 0; i < discountDatabase.discounts.size(); i++) {
			DiscountDecorator discount = discountDatabase.discounts.get(i);
			System.out.println("Discount name : " + discount.name );
			System.out.println("Discount amount :" + discount.amount + "$" );
		}
	}
}
