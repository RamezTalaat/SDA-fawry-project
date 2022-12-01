package component1;

public class Wallet {
    private Double amount;
    public Wallet()
    {
        amount = 0.0;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}