/*package component1;
import java.util.Vector;

public class UsersDatabase {
	public Vector<User> users = new Vector<User>();

}*/
package component1;
import java.util.Vector;

public class UsersDatabase {
	public Vector<User> users;
	public UsersDatabase()
	{
		 users = new Vector<User>();
		 User admin = new User(userType.admin);
		 admin.setName("admin");
		 admin.setPassword("admin");
		 admin.setMail("admin");
		 users.add(admin);  // to always add an admin when system starts
	}

}

