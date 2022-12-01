package component1;

public class User {
    private String name;
    private String password;
    private String mail;
    private String Type;
    int ID;
    Wallet wallet ;
    static int idCount = 1;
    public User()
    {
        ID = idCount++;
        wallet = new Wallet();
    }
    public void setName(String name_)
    {
    	name = name_;
    }
    public void setPassword(String password_)
    {
    	password = password_;
    }
    public void setMail(String mail_)
    {
    	mail = mail_;
    }
    public String getName()
    {
    	return name;
    }
    public String getPassword()
    {
    	return password;
    }
    public String getMail()
    {
    	return mail;
    }
}
