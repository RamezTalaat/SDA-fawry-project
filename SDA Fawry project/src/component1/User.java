package component1;
import java.util.Random;

enum userType
{
	user,admin
}

public class User {
    private String name;
    private String password;
    private String mail;
    private int creditCard;
    private userType type;
    int ID;
    static int idCount = 1;
    Random random = new Random();
    Wallet wallet ;
    public User()
    {
        ID = idCount++;
        wallet = new Wallet();
        type = userType.user;
        creditCard = random.nextInt(1000, 10000); // Generates random amount of money in the user's credit card between 1000 EGP and 10000 EGP
    }
    public User(userType _type)
    {
        ID = idCount++;
        wallet = new Wallet();
        type = _type;
        creditCard = random.nextInt(1000, 10000); // Generates random amount of money in the user's credit card between 1000 EGP and 10000 EGP
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
    public void setCreditCard(int creditCard_)
    {
    	creditCard=creditCard_;
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
    public int getCreditCard()
    {
    	return creditCard;
    }
    public userType getType()
    {
    	return type;
    }
}
