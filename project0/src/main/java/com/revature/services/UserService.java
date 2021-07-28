package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.ComicObj;

import com.revature.beans.User;
import com.revature.data.ComicDAO;
import com.revature.data.InventoryDAO;
import com.revature.data.UserDAO;


public class UserService {
// adding functionality to the users.
	private Logger log = LogManager.getLogger(UserService.class);
	public ComicDAO comDAO = new ComicDAO();
	public UserDAO ud = new UserDAO();
	public InventoryDAO invDAO = new InventoryDAO();
	
	//user login
	public User login(String name) {
		User u = ud.getUser(name);
		return u;
	}
	public String emailLogin(String email) {
		String e = ud.getEmail(email);
		return e;
	}
	public String getAll() {
		String all =  ud.getUsers().toString();
		return all;
	}
	public List<ComicObj> getCurCollection(User user){
		List<ComicObj> curCollection = comDAO.getComics();
		System.out.println("Current Collection: "+ curCollection);
		log.trace(curCollection);
		return curCollection;
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
		log.debug(u);
		return u;
		
	}
	public String getUserInfo(String name) {
		User u = ud.getUser(name);
		return u.toString();
	}
	
	public ComicObj pickComic(User user, String comicName) {
		//comicObj expects an id, a name, and a genre
		ComicObj choice = null;
		
	 choice = invDAO.getComicByName(comicName);
	 
	getCurCollection(user).add(choice);
	choice.setId((long)getCurCollection(user).size());
	ud.writeToFile();
	log.trace(choice);
	
	return choice;
	}
	
//	public ComicObj addComicToInv(ComicObj comic) {
//		ComicObj newComic = invDAO.addComic(comic);
//		return newComic;
//	}
	
}
