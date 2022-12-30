package com.example.fawrywebApp.APIServices;

import com.example.fawrywebApp.controller.RefundRequestController;
import com.example.fawrywebApp.controller.RegistrationController;
import com.example.fawrywebApp.controller.TransactionController;
import com.example.fawrywebApp.controller.WalletController;
import com.example.fawrywebApp.database.ActiveSessions;
import com.example.fawrywebApp.database.UsersDatabase;
import com.example.fawrywebApp.model.IGeneralUser;
import com.example.fawrywebApp.model.RefundRequest;
import com.example.fawrywebApp.model.Response;
import com.example.fawrywebApp.model.Transaction;
import com.example.fawrywebApp.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.Vector;

@RestController
@RequestMapping("/UserController")
public class SpringUserController 
{
    @GetMapping("/getUserInfo")
    public Response getUserInfo(@RequestBody User user){
        System.out.println("in get user info");
        ActiveSessions sessions = ActiveSessions.getInstance();
        Response response = new Response();
        response.object = sessions.checkSessionByUser(user);
        if(response.object == null) {
        	response.setStatus(false);
        	response.setMessage("user not logged in , please log in first");
        	return response;
        }
        response.setStatus(true);
        response.setMessage("User data returned successfully");
        return response;
<<<<<<< Updated upstream
=======
       
>>>>>>> Stashed changes
    }

    @PostMapping("/addMoneyToWallet/{uuid}/{amount}")
    public Response  addMoneyToWallet (@PathVariable ("uuid") UUID uuid , @PathVariable int amount){
        System.out.println("in add money to wallet");
        ActiveSessions sessions = ActiveSessions.getInstance();

        Response response = new Response();
        if(sessions.checkSession(uuid)){ // if uuid is in an active session
            User currentUser = (User)sessions.getUser(uuid);
            WalletController walletController = new WalletController();

            if ( walletController.setTransaction(currentUser , amount, null, null)) {
                response.setStatus(true);
                response.setMessage(amount + " was added to your wallet , your new wallet balance is " + currentUser.getWallet().getAmount());
                System.out.println(amount + "added to " + currentUser.getName()+
                        " wallet balance  , new wallet balance = "+currentUser.getWallet().getAmount()+" EGP");
            }
            else {
                response.setStatus(false);
                response.setMessage("could not add to wallet , insufficient amount of money in your credit card");
                System.out.println("failed add to wallet operation by " + currentUser.getName());   // system log
            }
        }
        else{
            response.setStatus(false);
            response.setMessage("User not logged in , please log in first");
        }
        return response;
    }
    
    @GetMapping("/getUserTransactions/{uuid}")
    public Response<Vector<Transaction>> getUserTransaction(@PathVariable ("uuid") UUID uuid)
    {
    	Response<Vector<Transaction>> response = new Response<Vector<Transaction>>();
    	if(!ActiveSessions.getInstance().checkSession(uuid)) {
    		response.setStatus(false);
    		response.setMessage("User not logged in , please log in first");
    		return response;
    	}
    	response.setStatus(true);
    	User user = (User)ActiveSessions.getInstance().getUser(uuid);
    	response.object = user.transactions;
    	if(response.object.size() == 0) {
    		response.setMessage("Sorry, the user hasn't made any transactions yet!");
    		return response;
    	}
    	response.setMessage("Done, user transactions retrived successfully!");
    	return response;
    }
    
    @PostMapping("/makeRefundRequest/{uuid}/{transactionID}")
    public Response<RefundRequest> makeRefundRequest(@PathVariable ("uuid") UUID uuid, @PathVariable ("transactionID") int transactionID)
    {
    	Response<RefundRequest> response = new Response<RefundRequest>();
    	if(!ActiveSessions.getInstance().checkSession(uuid)) {
    		response.setStatus(false);
    		response.setMessage("User not logged in , please log in first");
    		return response;
    	}
    	TransactionController transactionController = new WalletController();
    	Transaction transaction;
    	transaction = transactionController.getUserTransaction((User)ActiveSessions.getInstance().getUser(uuid), transactionID);
    	if(transaction == null) {
    		response.setStatus(false);
    		response.setMessage("Sorry, wrong transaction ID");
    		return response;
    	}
    	RefundRequestController refundRequestController = new RefundRequestController();
    	response.object = refundRequestController.makeRefundRequest((User)ActiveSessions.getInstance().getUser(uuid), transaction);
    	if(response.object == null) {
    		response.setStatus(false);
        	response.setMessage("Sorry, a refund request has been already made for the selected transaction");
        	return response;
    	}
    	response.setStatus(true);
    	response.setMessage("Done, a refund request has been made successfully!");
    	return response;
    }
}





