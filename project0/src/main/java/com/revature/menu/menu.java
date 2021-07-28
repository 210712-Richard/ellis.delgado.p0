package com.revature.menu;

import java.util.List;

import java.util.Scanner;



import com.revature.beans.ComicObj;
import com.revature.beans.User;
import com.revature.services.UserService;
import com.revature.data.InventoryDAO;
import com.revature.data.UserDAO;
import com.revature.data.UserDAO;
import com.revature.util.SingletonScanner;


public class Menu {
	
	private UserService us = new UserService();
	private UserDAO ud = new UserDAO();
	private InventoryDAO invDAO = new InventoryDAO();
	
	public void startApp() {
		mainLoop: while(true) {
			 switch(mainMenu()) {
			 	case 1: 
			 		System.out.println("input method");
			 		loginMenu();
			 		
			 		break;
			 	case 2 :
			 	
			 		registerMenu();
			 		System.out.println("Register method");
			 		break;
			 		
			 	case 3 : 
			 		System.out.println("See ya!");
			 		break mainLoop;
//			 	case 4: 
//			 		System.out.println("Return users");
//			 		returnUsers();
//			 		break;
			}
		}
	}
	
	

	private int mainMenu() {
		System.out.println("Hi! Welcome to the Comic Shop!");
		System.out.println("Please select an option: ");
		System.out.println("\t1. Login");
		System.out.println("\t2. Create an Account");
		System.out.println("\t3. Leave Shop");
		
		int choice = select();
		return choice;
		
	}
	

	public void loginMenu() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Hi! Please enter your login information!");
		System.out.println("Username:");
		String userName = myObj.nextLine();
		System.out.println("Email");
		String emailInput = myObj.nextLine();
		System.out.println("input: " + userName +" "+ emailInput );
		//if user login is true
 		//run playerMenu or ownerMenu
		User u = us.login(userName);
		String e = us.emailLogin(emailInput);
		if(u == null) {
			System.out.println("Incorrect name. Please try again");
		}
		if(e == null){
			System.out.println("Incorrect email. Please try again.");
		}else {
			User loggedUser = u;
			System.out.println("Welcome back "+ u.getUsername()+ "!");
				switch(loggedUser.getType()) {
				case Customer:
					System.out.println("Now entering the customer menu!");
					customer(loggedUser);
					break;
				case Manager: 
					System.out.println("Now entering the Manager portal!");
					manager(loggedUser);
					break;
				}
				
		}
	}
	


	public void registerMenu() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Hi! Please enter your information!");
		System.out.println("Username:");
		String userName = myObj.nextLine();
		System.out.println("Email");
		String emailInput = myObj.nextLine();
		System.out.println("Favorite Superhero: ");
		String superHero = myObj.nextLine();
		System.out.println("Favorite Comic or Issue: ");
		String comicBook = myObj.nextLine();
//		System.out.println("Are you a customer or manager?");
//		String accountType = myObj.nextLine();
//		if ()){}
		
		User newUser = us.register(userName, emailInput, superHero, comicBook);
		System.out.println("New User created!");
		System.out.println("User: " + newUser);
//		
		
	
	}
	// Customer Portal
	public void customer(User loggedUser) {
		
		customerLoop:
			while(true) {
				switch (customerMenu()) {
				case 1: 
					System.out.println("Viewing inventory");
					getCurrentInventory();
					break;
					
				case 2:
					System.out.println("Viewing your comics");
					getCurrentCollection(loggedUser);
					break;
				
				case 3: 
					System.out.println("Retrieving Account Info");
					getUser(loggedUser);
					break;
				case 4: 
					System.out.println("Here are the current comics");
					getCurrentInventory();
					System.out.println("Please enter the name and genre you want!");
					addComictoCollection(loggedUser);
					getCurrentInventory();
					break;
					
				case 5: 
					System.out.println("Adios Muchacho!");
					break customerLoop;
				}
					
			}
	}
	//Option Menu for customer
	
	public int customerMenu() {

		System.out.println("Please select an option: ");
		System.out.println("\t1. View Comics");
		System.out.println("\t2. View your comics");
		System.out.println("\t3. View your account info");
		System.out.println("\t4. Get a comic");
		System.out.println("\t5. Leave Shop");
		int choice = select();
		return choice;
	}
	public void getUser(User loggedUser) {
		String name = loggedUser.getUsername();
		String email = loggedUser.getEmail();
		String superhero = loggedUser.getSuperhero();
		String comicBook = loggedUser.getComic();
		
		System.out.println("Username: "+ name + ", email:" + email + ", favorite Superhero:" + superhero + ", and favorite comic: " + comicBook + "");
	}
	
	
	//Manager Portal 
	
	private void manager(User loggedUser) {
		managerLoop:
			while(true) {
				switch (managerMenu()) {
				case 1: 
					
					getCurrentInventory();
					break;
					
				case 2:
					System.out.println("Viewing your comics");
					getCurrentCollection(loggedUser);
					break;
				
				case 3: 
					System.out.println("Retrieving Account Info");
					getUser(loggedUser);
					break;
					
				case 4: 
					System.out.println("Retrieving All Users");
					//this isn't return user data as of yet
					returnUsers();
					break;
					
				case 5: 
					System.out.println("Here are the current comics");
					getCurrentInventory();
					System.out.println("Please enter the name and genre you want!");
					addComictoCollection(loggedUser);
					getCurrentInventory();
					break;
				case 6: 
					System.out.println("Adios Muchacho!");
					break managerLoop;
				}
					
			}
		
	}
	// Option menu for manager
	


	public int managerMenu() {
//		return null
		System.out.println("Hi! Welcome to the Comic Shop!");
		System.out.println("\t1. View Comics");
		System.out.println("\t2. View your comics");
		System.out.println("\t3. View your account info");
		System.out.println("\t4. View all Users");
		System.out.println("\t5. Get a comic");
		System.out.println("\t6. Leave Shop");
		int choice = select();
		return choice;
	};
	private void returnUsers() {
		// TODO Auto-generated method stub
		String u =  ud.getAllUsers();
		System.out.println("Users: "+ u);
		
	}
	
	private int select() {
		int choice;
		Scanner scan = new Scanner(System.in);
		try {
			choice = Integer.parseInt(scan.nextLine());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Please enter a number");
			choice = -1;
		};
		return choice;
	}
	private void getCurrentCollection(User loggedUser){
		us.getCurCollection(loggedUser);
		
	}
	private void getCurrentInventory(){
		List<ComicObj> comics = invDAO.getComics();
		String comicList = comics.toString();
		System.out.println("Current Inventory: " + comicList);
		
	}

	private Object addComictoCollection(User loggedUser) {
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Comic Name");
		String comicName = myObj.nextLine();
	
		if(comicName == null ) {
			System.out.println("Please input a name");
			return null;
		}
		
		Object newComic = us.pickComic(loggedUser, comicName);
		return newComic;
		
	}




//	public Inventory getInv() {
//		inv.get()
//		return inv;
//	}



//	public void setInv(Inventory inv) {
//		this.inv = inv;
//	}

}
