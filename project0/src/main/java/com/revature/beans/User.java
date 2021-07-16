package com.revature.beans;

import java.util.List;

//so here i want to establish my user class
// what will it be?
/*
 * What will i require to make a new user
 * 	-name
 * - id
 * 	- email
 * 	- favorite super hero?
 * 	- type of user (manager or customer)
 * 			- do i distinguish the manager and customer here or do i Just builder the customer for now?
 */
public class User {
	
	private String username;
	private Integer id;
	private String email;
	private String superhero;
	//I need to create a Usertype class so that we can differentiate the two
	private UserType type;
	// how do i add to the user's collection
			//I'd have to have an array for the comics
	private List<ComicObj> collection; 
	
	//now we gotta use a constructor to establish user type
	public User() {
		super();
		this.type = UserType.Customer;
		
	}
	
	public User(String username, Integer id, String email, String superhero) {
		this();
		this.username = username;
		this.id = id;
		this.email = email;
		this.superhero = superhero;
//		this.collection = collection;
		
	}
	//now we can create functions to call on when retrieving user info 
	
	public String addComic() {
		
	return ;
	}
	
}
