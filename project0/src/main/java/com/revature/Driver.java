package com.revature;

//import com.revature.controllers.UserController;
////import com.revature.menu.Menu;
import com.revature.controllers.UserControllerImp;

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
		
		UserControllerImp uCont = new UserControllerImp();
		app.get("/", (ctx)-> ctx.html("Javalin is working"));
		//login
		app.post("/users", uCont::login);
		//register
		app.put("/users/:username", uCont::register);
		//view collection
		app.get("/users/:username/collection", uCont::getCurCollection);
		//view your info
		app.get("/users/:username/info", uCont::getUserInfo);
		//view all users
		app.get("/users/:username/usersInfo", uCont::getAll);
		//view inventory
		app.get("/users/inventory", uCont::getComics);
		// select from inventory
		app.post("/users/:username/inventory/:comicName", uCont::pickComic);
		
	}

}
