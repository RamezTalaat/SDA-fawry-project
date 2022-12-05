package component1;

public class MonthlyReceipt implements Receipt{

	@Override
	public void getReceipt() {
		System.out.println("Receipt will be sent monthly");
	}
}
