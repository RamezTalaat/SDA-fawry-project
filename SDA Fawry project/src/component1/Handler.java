package component1;

public interface Handler {

	public void handleForm(Form form,  User user,  Service service); // Every handler should handle the Form depending on the purpose of the form but in this system
	// the handler will only use the amount
	
}
