package com.revature.services;

import com.revature.beans.ComicObj;
import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.data.UserDAO;
import com.revature.data.UserDAOFile;

public class UserService {
// adding functionality to the users.
	
	public UserDAOFile ud = new UserDAOFile();
	
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
		User all = (User) ud.getUsers();
		return all;
	}
	
	
	// creating a new user
	public User register(String username, String email, String superhero, String comic) {
		User u = new User();
		u.setUsername(username);
		u.setEmail(email);
		u.setSuperhero(superhero);
		u.setComic(comic);
//		u.setType(null);
		ud.addUser(u);
		ud.writeToFile();
		return u;
	}
	
//	public ComicObj pickComic(User user) {
//		ComicObj pickedComic = null;
//		
////		List<ComicObj> comics = 
//	}
//	
}
