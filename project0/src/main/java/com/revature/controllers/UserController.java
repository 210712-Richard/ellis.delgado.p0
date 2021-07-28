package com.revature.controllers;

import com.revature.beans.ComicObj;

import io.javalin.http.Context;

public interface UserController {
	/*
	 * what methods do i need?
	 *  View Comics
		View your comics
		View your account info
		 View all Users
		 Get a comic"
	 	Leave Shop"
	 */

		void login(Context ctx);
		
		void emailLogin(Context ctx);
		
		void register(Context ctx);
		
		void pickComic(Context ctx);
		
		void getCurCollection(Context ctx);
		
		void getAll(Context ctx);
		
		//returns inventory
		void getComics(Context ctx);
//


		void getUserInfo(Context ctx);
}
