package com.revature.beans;

import java.io.Serializable;

public interface ComicObj extends Serializable{
	String comic = "";
	
	Long getId();
	void setId(long size);
	
	String getName();
	void getName(String name);
	
	String getGenre();
	void getGenre(String genre);
}
