package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ComicObj;
import com.revature.beans.ComicBook;

public class ComicDAO {

		private static String filename = "collection.dat";
		private static List<ComicObj> comics;
		
		static {
			DataSerializer<ComicObj> dataSer = new DataSerializer<ComicObj>();
			comics = dataSer.readObjectsFromFile(filename);
			
			if (comics == null) {
				comics = new ArrayList<ComicObj>();
				ComicBook collection = new ComicBook("Justice League #1", "superhero");
				collection.setId((long)comics.size());
				comics.add(collection);
				
				collection = new ComicBook("Spawn", "superhero");
				collection.setId((long)comics.size());
				comics.add(collection);
			}
			
		}
		public void addComic(ComicObj comic) {
			comic.setId((long)comics.size());
			comics.add(comic);
		}		
		public List<ComicObj> getComics(){
			return comics;
		}
		public ComicObj getComic(Long id) {
		
			return comics.stream()
					.filter((g)-> g.getId().equals(id))
					.findFirst()
					.orElse(null);
		}
		public ComicObj getComicByName(String name) {
			return comics.stream()
					.filter((g)-> g.getName().equals(name))
					.findFirst()
					.orElse(null);
		}
		public ComicObj getComicByGenre(String genre) {
			return comics.stream()
					.filter((g)-> g.getGenre().equals(genre))
					.findFirst()
					.orElse(null);
		}
		public void writeToFile() {
			new DataSerializer<ComicObj>().writeObjectsToFile(comics, filename);
		}
}
