package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.beans.UserType;

//the user database access object or DAO will allow us to access users 
public class UserDAO {
	private static String filename = "user.dat";
	private static List<User> users; 
	
		static {
			DataSerializer<User> ds = new DataSerializer<User>();
			users = ds.readObjectsFromFile(filename);
			
			if (users == null) {
				users = new ArrayList<User>();
				users.add(new User(users.size(), "Bruce", "bwayne@gmail.com", "Superman", "Death of Superman"));
				users.add(new User(users.size(), "Matt", "mmurdock@gmail.com", "Spiderman", "Amazing Fantasy"));
				users.add(new User(users.size(), "Boba", "bfett@gmail.com", "Hulk", "Incredible Hulk"));
				User owner = new User(users.size(), "Stan", "slee@gmail.com", "Deadpool", "Infinty Gauntlet");
				owner.setType(UserType.Manager);
				users.add(owner);
				ds.writeObjectsToFile(users, filename);
			}
		}
	public void addUser(User u) {
		u.setId(users.size());
		users.add(u);
	}
	public List<User> getUser(){
		return users;
	}
	public User getUser(String username) {
//		for(int user = users[0]; user < users.size(); user++) {
//			if (user.getUsername().equals(username)) {
//				return user;
//			}
		for( User user: users) {
			if(user.getUsername().equals(username)) {
				return user;
		}
		}
		return null;
	}
}