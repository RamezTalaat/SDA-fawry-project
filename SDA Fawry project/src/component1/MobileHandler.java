package component1;

public class MobileHandler implements Handler{

	@Override
	public void handleForm(Form form,  User user,  Service service) {
		// TODO Auto-generated method stub
		PaymentController paymentController = form.getPaymentMethod();
		System.out.println("user's answers:- ");
		form.getForm();
		paymentController.setTransaction(user, form.getAmount(), null, service);
	}
}
