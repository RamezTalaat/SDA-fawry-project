package component1;

public class LandlineService extends Service{
	public Receipt receipt;
	public LandlineService()
	{
		setType("LandlineService");
	}
	public void setReceipt(Receipt receipt_)
	{
		receipt=receipt_;
	}
	public void payForService(User user) {
		form.viewForm();
		handler.handleForm(form, user, this);
		receipt.getReceipt();
	}
}
