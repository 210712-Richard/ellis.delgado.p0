package com.revature.beans;

//import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory  {
	public static void InventoryArray() {
	LinkedList<String> inventory = new LinkedList<String>();
	
		if(inventory.equals(null)) {
			inventory.add("Action Comics #1");
			inventory.add("Dark Knight Returns");
			inventory.add("Invincible");
		};
		System.out.println("Inventory: "+ inventory);
		
//		Iterator<String> iterator= inventory.iterator();
//	     while(iterator.hasNext()){
//	       System.out.println(iterator.next());
//	};
	
	}

	public LinkedList<String> get(List inventory) {
		return null;
		
		
	}
//	@Override
//	public String toString() {
//		return inventory;
//		
//	}
	
}
