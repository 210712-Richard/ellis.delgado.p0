package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.ComicObj;
import com.revature.beans.User;

public class Menu {
	
	public void startApp() {
		inputMenu();
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
}
