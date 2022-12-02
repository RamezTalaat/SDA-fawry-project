package component1;
import java.util.Vector;

public class TransactionDataBase {
	public Vector<Transaction> transactions = new Vector<Transaction>();
	public void addTransaction(Transaction transaction)
	{
		transactions.add(transaction);	
	}
}
