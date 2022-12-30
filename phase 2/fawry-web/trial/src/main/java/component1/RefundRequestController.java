package component1;

public class RefundRequestController {
	RefundRequestDatabase refundRequestDatabase = RefundRequestDatabase.getInstance();
	/*public RefundRequestController(RefundRequestDatabase refundRequestDatabase_)
	{
		refundRequestDatabase = refundRequestDatabase_;
	}*/
	public boolean makeRefundRequest(int option, User user)
	{
		RefundRequest refundRequest = new RefundRequest(user, user.transactions.get(option-1));
		refundRequestDatabase.refundRequests.add(refundRequest);
		return true;
	}
	public boolean checkTransactionExistence(int option, User user)
	{
		for(int i=0; i<refundRequestDatabase.refundRequests.size(); i++) {
			if(user.transactions.get(option-1).equals(refundRequestDatabase.refundRequests.get(i).transaction)) {
				return true;
			}
		}
		return false;
	}
	public boolean validateOption(int option, User user)
	{
		if(option > user.transactions.size()) {
			return false;
		}
		return true;
	}
	public void listRefundRequests()
	{
		if(refundRequestDatabase.refundRequests.isEmpty()) {
			System.out.println("Sorry, no pending refund requests");
			return;
		}
		for(int i=0; i<refundRequestDatabase.refundRequests.size(); i++) {
			System.out.println("Request "+(i+1)+" :-");
			System.out.println("Requested by "+refundRequestDatabase.refundRequests.get(i).getTransaction().getUser().getName());
			System.out.println("Transaction type: "+refundRequestDatabase.refundRequests.get(i).getTransaction().type);
			System.out.println("Transaction Amount: "+refundRequestDatabase.refundRequests.get(i).getTransaction().getAmount());
			if(refundRequestDatabase.refundRequests.get(i).getTransaction().type.equals("paymentTransaction")) {
				System.out.println("Transaction Service Name: "+refundRequestDatabase.refundRequests.get(i).getTransaction().getService().getName());
				System.out.println("Transaction Service Type: "+refundRequestDatabase.refundRequests.get(i).getTransaction().getService().getType());
			}
		}
	}
	public void removeRequest(RefundRequest refundRequest, String answer)
	{
		for(int i=0; i<refundRequestDatabase.refundRequests.size(); i++) {
			if(refundRequest.equals(refundRequestDatabase.refundRequests.get(i))){
				refundRequestDatabase.refundRequests.remove(i);
				break;
			}
		}
		if(answer.equals("approve")) {
			for(int i=0; i<refundRequest.getUser().transactions.size(); i++) {
				if(refundRequest.getTransaction() == refundRequest.getUser().transactions.get(i)) {
					refundRequest.getUser().transactions.remove(i);
					break;
				}
			}
		}
	}
}
