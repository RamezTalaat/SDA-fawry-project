package component1;

public class QuarterReceipt implements Receipt{

	@Override
	public void getReceipt() {
		System.out.println("Receipt will be sent every quarter (every 3 months)");
	}
	
}
