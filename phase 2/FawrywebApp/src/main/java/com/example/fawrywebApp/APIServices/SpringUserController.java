package com.example.fawrywebApp.APIServices;

import com.example.fawrywebApp.controller.RegistrationController;
import com.example.fawrywebApp.controller.WalletController;
import com.example.fawrywebApp.database.ActiveSessions;
import com.example.fawrywebApp.model.Response;
import com.example.fawrywebApp.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/UserController")
public class SpringUserController {

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
       /* if(sessions.checkSessionByUser(user)!= null){ // if uuid is in an active session
            User tmpUser = new User();  //because it is guaranteed to be a user not an admin (user) sessions.get
            RegistrationController registrationController = new RegistrationController();
            tmpUser = registrationController.checkUserExistence(tmpUser.getMail(), tmpUser.getPassword());

            if(tmpUser==null) {
                System.out.println("failed to get user info , wrong password or mail");
                response.setStatus(false);
                response.setMessage("Wrong password or mail , there is no such user");
                return response;
            }
            response.setStatus(true);
            response.setMessage("User data returned successfully ");
            response.object = tmpUser;
            System.out.println("Done, user "+tmpUser.getName()+ " info retrieved!");
        }
        else{
            response.setStatus(false);
            response.setMessage("user not logged in , please log in first");
        }*/
        

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
            response.setMessage("user not logged in , please log in first");
        }
        return response;
    }
}
