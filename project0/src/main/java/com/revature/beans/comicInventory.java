package com.revature.beans;

//import java.util.Objects;


//import com.revature.beans.ComicObj;

public class comicInventory implements ComicObj{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String comicName;
	private String genre;
	
	public comicInventory(String comicName, String genre) {
		super();
		this.id = id;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comicName == null) ? 0 : comicName.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		comicInventory other = (comicInventory) obj;
		if (comicName == null) {
			if (other.comicName != null)
				return false;
		} else if (!comicName.equals(other.comicName))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "comicInventory [id=" + id + ", comicName=" + comicName + ", genre=" + genre + "]";
	}
	
	
}
