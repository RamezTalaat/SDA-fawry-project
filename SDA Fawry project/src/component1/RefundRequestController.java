package component1;

public class RefundRequestController {
	RefundRequestDatabase refundRequestDatabase;
	public RefundRequestController(RefundRequestDatabase refundRequestDatabase_)
	{
		refundRequestDatabase = refundRequestDatabase_;
	}
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
}
