package com.revature.services;


import java.util.List;

import com.revature.beans.*;

public interface UserSerInterface {

	 User login(String name);
	 
	 String emailLogin(String email);
	 
	 String getAll();
	 
	 List<ComicObj> getCurCollection(User user);
	 
	 User register(String username, String email, String superhero, String comic);
	 
	 ComicObj pickComic(User user, String comicName);
	 
//	 ComicObj addComicToInv(ComicObj comic);
	 
	
}
