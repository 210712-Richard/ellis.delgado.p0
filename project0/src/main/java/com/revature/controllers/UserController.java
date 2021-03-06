package com.revature.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

import com.revature.services.*;
import com.revature.data.*;
import com.revature.beans.*;

import io.javalin.http.Context;


public class UserController {
	private static Logger log = LogManager.getLogger(UserController.class);
	private UserService uService = new UserService();
	private InventoryDAO invDAO = new InventoryDAO();
	private ComicDAO comDAO = new ComicDAO();
	
	
	public void login(Context ctx) {
		log.trace("Login Method");
		log.debug(ctx.body());
		
		User user = ctx.bodyAsClass(User.class);
		log.debug(user);
		
		user = uService.login(user.getUsername());
		user.setCollection(comDAO.getComics());
		log.debug(user);
		
//		if(user == null) {
//			ctx.status(401);
//		}
		ctx.sessionAttribute("loggedUser", user);
		return;
	}

	
	public void emailLogin(Context ctx) {
		log.trace("Email Login Method");
		log.debug(ctx.body());
		
		User user = ctx.bodyAsClass(User.class);
		log.debug(user);
		
		String userEmail = uService.emailLogin(user.getEmail().toString());
		log.debug(userEmail);
		
		if(userEmail == null) {
			ctx.status(401);
		}
		ctx.sessionAttribute("email", userEmail);
		return;
		
	}

	
	public void register(Context ctx) {
		User user = ctx.bodyAsClass(User.class);
		
			User newUser = uService.register(user.getUsername(), user.getEmail(), user.getSuperhero(), user.getComic());
		
		if (newUser == null) {
			log.error("Failed to make new user" + newUser);
			ctx.status(400);
		}
		ctx.status(201);
		ctx.json(newUser);
	}
	

	
	public void pickComic(Context ctx) {
		User loggedUser = ctx.sessionAttribute("loggedUser");
		String username= ctx.pathParam("username");
		String comicName = ctx.pathParam("comicName");
		
		
		if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			log.error("Error with user (either null or accessing other user account)");
			return;
		}
		ComicObj comic = uService.pickComic(loggedUser, comicName);
			if (comic == null) {
				ctx.status(402);
				log.error("Failed to add comic to collection"+ comic);
			}else {

		ctx.json(comic);
			}
	}

	
	public void getCurCollection(Context ctx) {
		User loggedUser = ctx.sessionAttribute("loggedUser");
		String username= ctx.pathParam("username");
		

		if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			log.error("Error with user (either null or accessing other user account)");
			return;
		}
		
		List<ComicObj> collection = uService.getCurCollection(loggedUser);
		collection.toString();
		log.trace(collection);
		ctx.json(collection);
		
	}

	
	public void getAll(Context ctx) {
		User loggedUser = ctx.sessionAttribute("loggedUser");
		String userType= loggedUser.getType().toString();
		
		if(loggedUser == null || userType != "Manager" ) {
			ctx.status(403);
			log.error("User Doesn't have manager access");
			return;
		}
		
		try {
		String allUsers = uService.getAll();
		ctx.json(allUsers);
		
		}catch (Exception e) {
			ctx.status(500);
		 e.printStackTrace(); 
		 log.error("Failed to load Users"+e);
		}
		
	}
	
	
	public void getUserInfo(Context ctx) {
		User loggedUser = ctx.sessionAttribute("loggedUser");
		String username= loggedUser.getUsername();
		
		if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			log.error("Error with user (either null or accessing other user account)");
			return;
		}
		String userInfo = uService.getUserInfo(loggedUser.getUsername());
		
		ctx.json(userInfo);
		
	}


	//returns full inventory
	public void getComics(Context ctx) {
		List<ComicObj> inventory = invDAO.getComics();
		inventory.toString();
		ctx.json(inventory);
		
	}
	
	public void addComicToInv(Context ctx) {
		
		
		User loggedUser = ctx.sessionAttribute("loggedUser");
		String username= ctx.pathParam("username");
		String comicName = ctx.pathParam("comicName");
		String genre = ctx.pathParam("genre");
		
		
		if(loggedUser == null || !loggedUser.getType().equals(UserType.Manager)|| !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			log.error("Error with user (either null or accessing other user account)");
			return;
		}
		ComicObj comic = uService.addComicToInv(comicName, genre);;
			if (comic == null) {
				ctx.status(402);
				log.error("Failed to add comic to collection"+ comic);
			}else {

		ctx.json(comic);
			}
		
	}


}
