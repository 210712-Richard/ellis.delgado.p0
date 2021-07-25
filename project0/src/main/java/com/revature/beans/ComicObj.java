package com.revature.beans;

import java.io.Serializable;

public interface ComicObj extends Serializable{
	String comic = "";
	
	Long getId();
	void setId(Long id);
	
	String getName();
	void setName(String name);
	
	String getGenre();
	void setGenre(String genre);
}
