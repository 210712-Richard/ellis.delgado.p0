package com.revature.data;


import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ComicObj;
import com.revature.beans.comicInventory;

public class InventoryDAO {
	private static String filename = "inventory.dat";
	private static List<ComicObj> comics;
	
	static {
		DataSerializer<ComicObj> dataSer = new DataSerializer<ComicObj>();
		comics = dataSer.readObjectsFromFile(filename);
		
		if(comics == null) {
			
			comics = new ArrayList<ComicObj>();
			comicInventory inventory = new comicInventory( "Allstar Superman", "superhero");
			inventory.setId((long)comics.size());
			comics.add(inventory);
			
			inventory = new comicInventory( "Blankets", "Slice of Life");
			inventory.setId((long)comics.size());
			comics.add(inventory);
			
			inventory = new comicInventory( "Batman: The Long Halloween", "superhero");
			inventory.setId((long)comics.size());
			comics.add(inventory);
			
			inventory = new comicInventory( "Maus", "Biography");
			inventory.setId((long)comics.size());
			comics.add(inventory);
			
			dataSer.writeObjectsToFile(comics, filename);
		}
		
	}

}
