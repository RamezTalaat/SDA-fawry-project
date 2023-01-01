package com.example.fawrywebApp.APIServices;

import java.util.UUID;

import com.example.fawrywebApp.controller.RegistrationController;
import com.example.fawrywebApp.database.ActiveSessions;
import com.example.fawrywebApp.model.User;
import com.example.fawrywebApp.model.Admin;
import com.example.fawrywebApp.model.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RegistrationController")
public class SpringRegistrationController {

    @PostMapping("/signUp")
    public Response signUp(@RequestBody User user){
        System.out.println("in user sign up");
        User tmpUser = new User();
        RegistrationController registrationController = new RegistrationController();
        tmpUser = registrationController.addUser(user.getName(), user.getMail(), user.getPassword());
        Response response = new Response();
        if(tmpUser==null) {
            System.out.println("sign up failed , user name or e-mail already used");
            response.setStatus(false);
            response.setMessage("Sorry, user name or e-mail already used");
            return response;
        }
        ActiveSessions sessionsDatabase = ActiveSessions.getInstance();
        UUID uuid=UUID.randomUUID();   // to generate random session UUID
        sessionsDatabase.addSession(uuid , tmpUser);

        response.setStatus(true);
        response.setMessage("Done, user was added successfully!");
        response.object = uuid;
        sessionsDatabase.printDatabase();
        return response;

    }
    @PostMapping("/signIn")
    public Response signIn(@RequestBody User user){
        System.out.println("in user sign in");
        Response response = new Response();
        ActiveSessions sessionsDatabase = ActiveSessions.getInstance();
        if(sessionsDatabase.checkUserSession(user)){    //if user is already signed in
            response.setStatus(false);
            response.setMessage("can not sign in , user is already signed in");
            return response;
        }
        User tmpUser = new User();
        RegistrationController registrationController = new RegistrationController();
        tmpUser = registrationController.checkUserExistence(user.getMail(), user.getPassword());

        if(tmpUser==null) {       // if user is not signed up in the system
            System.out.println("failed user sign in , wrong password or mail");
            response.setStatus(false);
            response.setMessage("Wrong password or mail , there is no such user");
            return response;
        }
        UUID uuid=UUID.randomUUID();   // to generate random session
        sessionsDatabase.addSession(uuid , tmpUser);

        System.out.println("Done, user "+tmpUser.getName()+ " logged in!");
        response.setStatus(true);
        response.setMessage("Welcome " + tmpUser.getName());
        response.object = uuid;
        sessionsDatabase.printDatabase();
        return response;

    }
    @DeleteMapping("/signOut/{uuid}")
    public Response signOut(@PathVariable("uuid") UUID uuid) {
    	System.out.println("user log out");
    	Response response = new Response();
    	ActiveSessions sessionsDatabase = ActiveSessions.getInstance(); 
    	if(sessionsDatabase.checkSession(uuid)){
    		response.setStatus(true);
    		sessionsDatabase.removeSession(uuid);
    		System.out.println("UUID has been deleted");
    		response.setMessage("user was log out successfully!");
    		return response;
    	}
    	response.setStatus(false);
    	response.setMessage("user with uuid " + uuid + " was not signed in the system");
    	return response;
    }

    @PostMapping("/signInAsAdmin")
    public Response<UUID> signIn(@RequestBody Admin admin){  // Generates a new UUID each time an admin enters the name, mail and password properly
        Admin adminData  = new Admin();
        adminData.setName("admin");   //default admin data
        adminData.setPassword("admin");
        adminData.setMail("admin@gmail.com");
        System.out.println("in admin sign in");
        Response<UUID> response = new Response<UUID>();
        ActiveSessions sessionsDatabase = ActiveSessions.getInstance();
        if (admin.getName().equals(adminData.getName()) && admin.getMail().equals(adminData.getMail()) && admin.getPassword().equals(adminData.getPassword())){
        	UUID uuid=UUID.randomUUID();   // to generate random session
            sessionsDatabase.addSession(uuid , adminData);
            System.out.println("Done, admin logged in successfully!");
            response.setStatus(true);
            response.setMessage("Welcome welcome dear admin");
            response.object = uuid;
            sessionsDatabase.printDatabase();
            return response;
        }
        response.setStatus(false);
        response.setMessage("Wrong admin credentials , access denied");
        return response;
    }
    @DeleteMapping("/signOutAsAdmin/{uuid}")
    public Response signOutAsAdmin (@PathVariable("uuid") UUID uuid){
    	Response response = new Response();
        ActiveSessions activeSessions = ActiveSessions.getInstance();
        if(activeSessions.checkSession(uuid)) {  // if admin is already logged in
        	activeSessions.removeSession(uuid);
        	response.setStatus(true);
        	response.setMessage("Admin signed out successfully");
        	return response;
        }
        response.setStatus(false);
        response.setMessage("Admin with uuid " + uuid + " was not signed in the system");
        return response;
    }

}