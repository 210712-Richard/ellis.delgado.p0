package com.revature.services;

import com.revature.beans.User;
import com.revature.data.UserDAO;

public class UserService {
// adding functionality to the users.
	
	public UserDAO ud = new UserDAO();
	
	//user login
	public User login(String name) {
		User u = ud.getUser(name);
		return u;
	}
	public String emailLogin(String email) {
		String e = ud.getEmail(email);
		return e;
	}
	public User getAll() {
		User all = (User) ud.getUser();
		return all;
	}
	
	
	// creating a new user
	public void register(String username, String email, String superhero, String comic) {
		User u = new User();
		u.setUsername(username);
		u.setEmail(email);
		u.setSuperhero(superhero);
		u.setComic(comic);
		ud.addUser(u);
		ud.writeToFile();
	}
}
