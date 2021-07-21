package com.revature.menu;

import java.util.Scanner;


import com.revature.beans.ComicObj;
import com.revature.util.SingletonScanner;
import com.revature.beans.User;
import com.revature.services.UserService;


public class Menu {
	
	private UserService us = new UserService();
	
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
		User e = us.login(emailInput);
		if(u == null) {
			System.out.println("Incorrect name. Please try again");
		}
		if(e == null){
			System.out.println("Incorrect email. Please try again.");
		}else {
			User loggedUser = u;
			System.out.println("Welcome: "+ u.getUsername());
				switch(loggedUser.getType()) {
				case Customer:
					System.out.println("Now entering the customer menu!");
					customerMenu();
					break;
				case Manager: 
					System.out.println("Now entering the Manager portal!");
					managerMenu();
					break;
				}
				
		}
	}
	
	public void registerMenu() {
		
	}
	public int customerMenu() {
		System.out.println("Welcome back");
		System.out.println("Please select an option: ");
		System.out.println("\t1. View Comics");
		System.out.println("\t2. View your comics");
		System.out.println("\t3. Leave Shop");
		int choice = select();
		return choice;
	}
	public int managerMenu() {
//		return null
		int van = 0;
		return van;
	};
	
	private int select() {
		int choice;
		Scanner scan = new Scanner(System.in);
		try {
			choice = Integer.parseInt(scan.nextLine());
		}catch(Exception e){
			e.printStackTrace();
			choice = -1;
		};
		return choice;
	}

}
