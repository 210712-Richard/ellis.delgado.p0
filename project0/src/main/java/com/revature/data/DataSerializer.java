package com.revature.data;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class DataSerializer<T>{
// using this class to read and write to a file
	
	public List<T> readObjectsFromFile(String filename){
		List<T> objects = null;
		try(ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));){
			// using a linkedlist since i know that i will be changing the size of the list
			objects = (ArrayList<T>) o.readObject();
			System.out.println("File has been read");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Read Objects from file method");
		}
		
		
		return objects;
	}
	public void writeObjectsToFile(List<T> objects, String filename) {
		try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename));){
			o.writeObject(objects);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("Write objects to file method");
		}
	}
}
