/*package component1;
import java.util.Vector;

public class UsersDatabase {
	public Vector<User> users;
	public UsersDatabase()
	{
		users = new Vector<User>();
	}

}*/
/*package component1;
import java.util.Vector;

public class UsersDatabase {
	public Vector<User> users = new Vector<User>();

}*/
package component1;
import java.util.Vector;

public class UsersDatabase {
	private static UsersDatabase instance = null;
	public Vector<User> users;
	
	private UsersDatabase() {
		// TODO Auto-generated constructor stub
		users = new Vector<User>();
	}	
	public static UsersDatabase  getInstance() {
		if(instance == null) {
			instance = new UsersDatabase();
		}
		return instance;
	}
	
	

}



