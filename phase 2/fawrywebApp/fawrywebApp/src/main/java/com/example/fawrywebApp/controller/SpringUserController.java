package com.example.fawrywebApp.controller;

import com.example.fawrywebApp.database.ActiveSessions;
import com.example.fawrywebApp.model.Response;
import com.example.fawrywebApp.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/UserController")
public class SpringUserController {

    @GetMapping("/getUserInfo/{uuid}")
    public Response getUserInfo(@PathVariable("uuid") UUID uuid){
        System.out.println("in get user info");
        ActiveSessions sessions = ActiveSessions.getInstance();

        Response response = new Response();

        if(sessions.checkSession(uuid)){ // if uuid is in an active session
            User tmpUser = sessions.getUser(uuid);
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
        }
        return response;

    }
}
