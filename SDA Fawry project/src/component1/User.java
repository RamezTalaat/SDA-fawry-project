package component1;

public class User {
    private String name;
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
}
