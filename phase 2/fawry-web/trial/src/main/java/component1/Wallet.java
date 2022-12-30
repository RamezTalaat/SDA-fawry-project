package component1;

public class Wallet {
    private int amount;
    public Wallet()
    {
        amount = 0;
    }

    public void setAmount(int amount_) {
    	amount = amount_;
    }

    public int getAmount() {
        return amount;
    }
}