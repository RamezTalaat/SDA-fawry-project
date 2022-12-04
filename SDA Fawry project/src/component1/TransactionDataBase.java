package component1;
import java.util.Vector;

public class TransactionDataBase {

	private static TransactionDataBase instance = null;
	public Vector<Transaction> transactions;
	
	private TransactionDataBase() {
		// TODO Auto-generated constructor stub
		transactions = new Vector<Transaction>();
	}
	
	public static TransactionDataBase  getInstance() {
		if(instance == null) {
			instance = new TransactionDataBase();
		}
		return instance;
	}
	
	
	public void addTransaction(Transaction transaction)
	{
		transactions.add(transaction);	
		//System.out.println(transaction.user.getName());
	}
}
