package com.revature.beans;

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
	
	//now we gotta use a constructor
	public User() {
		super();
		
	}
}
