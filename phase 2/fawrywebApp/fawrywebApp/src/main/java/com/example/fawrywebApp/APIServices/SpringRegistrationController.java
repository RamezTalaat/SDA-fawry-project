package com.example.fawrywebApp.APIServices;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.UUID;

import com.example.fawrywebApp.controller.RegistrationController;
import com.example.fawrywebApp.database.ActiveSessions;
import com.example.fawrywebApp.model.User;
import com.example.fawrywebApp.model.Admin;
//import com.example.fawrywebApp.service.PersonService;
//import com.example.fawrywebApp.service.PersonServiceImpl;
import com.example.fawrywebApp.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RegistrationController")
public class SpringRegistrationController {

    //@Autowired
    //PersonService personService = new PersonServiceImpl();

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
    @DeleteMapping("/logOut/{uuid}")
    public Response logOut(@PathVariable("uuid") UUID uuid) {
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
    	return response;
    }

    @PostMapping("/signInAsAdmin")
    public Response signIn(@RequestBody Admin admin){
        Admin adminData  = new Admin();
        adminData.setName("admin");   //default admin data
        adminData.setPassword("admin");
        adminData.setMail("admin@gmail.com");

        System.out.println("in admin sign in");
        Response response = new Response();
        ActiveSessions sessionsDatabase = ActiveSessions.getInstance();
        if(sessionsDatabase.checkUserSession(admin)){    //if ADMIN is already signed in
            response.setStatus(false);
            response.setMessage("user " + admin.getMail() + " is already signed in");
            return response;
        }
        if (admin.getName().equals(adminData.getName()) || admin.getMail().equals(adminData.getMail()) ||admin.getPassword().equals(adminData.getPassword())  ){
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
        if(activeSessions.checkSession(uuid)) {  // if admin is already loged in
        	activeSessions.removeSession(uuid);
        	response.setStatus(true);
        	response.setMessage("Admin signed out successfully");
        	return response;
        }
        response.setStatus(false);
        response.setMessage("Admin with uuid " + uuid + " was not signed in the system");
        return response;

        

    }


    /*@PostMapping("/add")
    public Response addPerson(@RequestBody Person p) {
        System.out.println("in add person" + p);
        boolean res = personService.addPerson(p);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("Person Already Exists");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Person created successfully");
        return response;
    }

    @PutMapping("/update")
    public Response updatePerson(@RequestParam("id") int id, @RequestParam("newName") String name) {
        Boolean res = personService.updatePerson(id, name);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("Person doesnt exist to update in the first place.");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Person updated successfully.");
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Response deletePerson(@PathVariable("id") int id) {
        System.out.println("in delete with id:" + id);
        boolean res = personService.deletePerson(id);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("Person Doesn't Exists");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Person deleted successfully");
        return response;
    }

    @GetMapping("/get/{id}")
    public Response<Person> getPerson(@PathVariable("id") int id) {
        System.out.println("in get with id:" + id);
        var person = personService.getPerson(id);
        Response<Person> response = new Response<Person>();
        if (person == null) {
            response.setStatus(false);
            response.setMessage("Person Not Found");
            response.object = null;

            return response;
        }

        response.setStatus(true);
        response.setMessage("Person Retrieved Successfully");
        response.object = person;

        return response;
    }

    @GetMapping("/get")
    public Person[] getAll() {
        System.out.println("in getAll");
        return personService.getAllPersons();
    }*/

}