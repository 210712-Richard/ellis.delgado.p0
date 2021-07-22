package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
	private String comic;
	private List<ComicObj>collection; 
	
	
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
		this.collection = new ArrayList<ComicObj>();
		
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

	public List<ComicObj> getCollection() {
		return collection;
	}

	public void setCollection(List<ComicObj> collection) {
		this.collection = collection;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(collection, other.collection) && Objects.equals(comic, other.comic)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(superhero, other.superhero) && type == other.type
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", id=" + id + ", email=" + email + ", superhero=" + superhero + ", type="
				+ type + ", comic=" + comic + ", collection=" + collection + "]";
	}

	
	
}
