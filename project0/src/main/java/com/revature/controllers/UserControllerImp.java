package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

import com.revature.services.*;
import com.revature.data.*;
import com.revature.beans.*;

import io.javalin.http.Context;


public class UserControllerImp {
	private static Logger log = LogManager.getLogger(UserControllerImp.class);
	private UserService uService = new UserService();
	private InventoryDAO invDAO = new InventoryDAO();
	private ComicDAO comDAO = new ComicDAO();
	
//	@Override 
	public void login(Context ctx) {
		log.trace("Login Method");
		log.debug(ctx.body());
		
		User user = ctx.bodyAsClass(User.class);
		log.debug(user);
		
		user = uService.login(user.getUsername());
		log.debug(user);
		
		if(user == null) {
			ctx.status(401);
		}
		ctx.sessionAttribute("loggedUser", user);
		return;
	}
	
	

}
