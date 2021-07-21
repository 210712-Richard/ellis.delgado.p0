package com.revature.beans;

import java.io.Serializable;
import java.util.List;
import com.revature.beans.UserType;
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
public class User implements Serializable{
	
	private static final long serialVersionUID = -6426075925303078798L;
	private String username;
	private Integer id;
	private String email;
	private String superhero;
	//I need to create a Usertype class so that we can differentiate the two
	private UserType type;
	// how do i add to the user's collection
			//I'd have to have an array for the comics
//	private List<ComicObj> collection; 
	//creating a field for comics
	private String comic;
	
	//now we gotta use a constructor to establish user type
	public User() {
		super();
		this.type = UserType.Customer;
		
	}
	
	public User( Integer id, String username,String email, String superhero, String comic) {
		this();
		this.id = id;
		this.username = username;
		this.email = email;
		this.superhero = superhero;
		this.comic = comic;
//		this.collection = collection;
		
	}
	//now we can create functions to call on when retrieving user info 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSuperhero() {
		return superhero;
	}

	public void setSuperhero(String superhero) {
		this.superhero = superhero;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
	public String getComic() {
		return comic;
	}
	public void setComic(String comic) {
		this.comic = comic;
	
	}
	
	
}
