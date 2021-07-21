package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.ComicObj;
import com.revature.beans.User;

public class Menu {
	
	public void startApp() {
		mainLoop: while(true) {
			 switch(mainMenu()) {
			 	case 1: 
			 		System.out.println("input method");
			 		inputMenu();
			 		
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
	

	public void inputMenu() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Hi! Please enter your login information!");
		System.out.println("Username:");
		String userName = myObj.nextLine();
		System.out.println("Email");
		String emailInput = myObj.nextLine();
		System.out.println("input: " + userName +" "+ emailInput );
	}
	
	public void registerMenu() {
		
	}
	
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
