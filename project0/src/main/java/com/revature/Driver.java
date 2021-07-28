package com.revature;

import com.revature.controllers.UserController;
//import com.revature.menu.Menu;

import io.javalin.Javalin;
public class Driver {

	public static void main(String[] args) {
//		Menu m = new Menu();
//		m.startApp();
		javalin();
	}

	private static void javalin() {
		//creating local host connection
		Javalin app = Javalin.create().start(8080);
		
//		UserController uCont = new UserController();
		
	}

}
