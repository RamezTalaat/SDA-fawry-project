package component1;

public class WalletController {
	public boolean addMoneyToWallet(User user,int amount){
		
		if(user.getCreditCard()>=amount) {
			 user.wallet.setAmount(user.wallet.getAmount()+amount);
			 user.setCreditCard(user.getCreditCard()-amount);
			 return true;
		}
	    return false;
	}

}
