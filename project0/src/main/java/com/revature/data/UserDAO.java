package com.revature.data;


import java.util.List;

import com.revature.beans.User;
import com.revature.beans.UserType;

//the user database access object or DAO will allow us to access users 
public class UserDAO {
	private static String filename = "user.dat";
	private static List<User> users; 
	
	static {
		DataSerializer<User> ds = new DataSerializer<User>();
	}
}
