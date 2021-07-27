package com.revature.services;

import java.util.List;

import com.revature.beans.ComicObj;

import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.data.InventoryDAO;
import com.revature.data.UserDAO;


public class UserService {
// adding functionality to the users.
	
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
	
	public ComicObj pickComic(User user, String comicName, String genre) {
		//comicObj expects an id, a name, and a genre
		ComicObj choice = null;
		
	
	List<ComicObj> comics = invDAO.getComics();
	 choice = invDAO.getComicByName(comicName);
//	if (choice.getName() != comics.get(comics.size()).getName()) {
//		System.out.println("Sorry, that comic isn't available!");
//		return null;
//	}
	// how do i set the new comic?
	 System.out.println("Choice: "+ choice);
	 System.out.println("Comics "+ comics);
	 System.out.println("Collection: "+ user.getCollection());
	choice.setGenre(genre);
	user.getCollection().add(choice);
	choice.setId((long) user.getCollection().size());
	ud.writeToFile();
	
	return choice;
	}
	
}
