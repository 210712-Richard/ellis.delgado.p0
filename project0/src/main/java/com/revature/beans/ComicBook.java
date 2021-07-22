package com.revature.beans;

import java.util.Objects;

import com.revature.beans.ComicObj;


public class ComicBook implements ComicObj{
	
	private Long id;
	private String comicName;
	private String genre;
	public ComicBook() {
		super();
		this.id = id;
	}
	
	public ComicBook(String comicName, String genre) {
		this();
		this.comicName = comicName;
		this.genre = genre;
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComicName() {
		return comicName;
	}
	public void setComicName(String comicName) {
		this.comicName = comicName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(comicName, genre, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComicBook other = (ComicBook) obj;
		return Objects.equals(comicName, other.comicName) && Objects.equals(genre, other.genre)
				&& Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "ComicBook [id=" + id + ", comicName=" + comicName + ", genre=" + genre + "]";
	}
	

}
