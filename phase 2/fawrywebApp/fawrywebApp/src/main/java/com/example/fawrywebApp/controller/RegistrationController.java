package com.example.fawrywebApp.controller;
import com.example.fawrywebApp.model.User;
import com.example.fawrywebApp.database.UsersDatabase;

public class RegistrationController {
	UsersDatabase usersDatabase;
	public RegistrationController()
	{
		usersDatabase = UsersDatabase.getInstance();
	}
	public User addUser(String userName, String userMail, String userPassword)
	{
		if(validateUser(userName, userMail)) {
			User user = new User();
			user.setMail(userMail);
			user.setName(userName);
			user.setPassword(userPassword);
			usersDatabase.users.add(user);
			return user;
		}
		return null;
	}
	public User checkUserExistence(String userMail, String userPassword)
	{
		for(int i=0; i<usersDatabase.users.size(); i++) {
			if(usersDatabase.users.get(i).getMail().equals(userMail) && usersDatabase.users.get(i).getPassword().equals(userPassword) ) {
				return usersDatabase.users.get(i);
			}
		}
		return null;
	}
	public boolean validateUser(String userName, String userMail)
	{
		for(int i=0; i<usersDatabase.users.size(); i++) {
			if(usersDatabase.users.get(i).getMail().equals(userMail) || usersDatabase.users.get(i).getName().equals(userName)) {
				return false;
			}
		}
		return true;
	}
	
}

