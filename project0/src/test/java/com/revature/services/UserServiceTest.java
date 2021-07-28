package com.revature.services;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.revature.beans.*;
import com.revature.data.*;

import jdk.internal.org.jline.utils.Log;

import org.apache.logging.log4j.*;

public class UserServiceTest {

		private static UserService service;
		private static User user;
		
		
		@BeforeAll
		public static void setUpClass() {
			user = new User();
			user.setUsername("Test");

		}
		@BeforeEach
		public void setUpTest() {
			service = new UserService();
			service.ud = Mockito.mock(UserDAO.class);
			service.comDAO = Mockito.mock(ComicDAO.class);
			}
		
		@Test
		public void testRegistration() {
			String username = "Bob";
			String email = "bbob@gmail.com";
			String superhero = "Bob";
			String comic = "Bob Attacks";
			
			service.register(username, email, superhero, comic);
			
//			UserType type = UserType.Manager;
//			service.ud.getUser(username).setType(type);
//			
			ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
			Mockito.verify(service.ud).addUser(captor.capture());
			Mockito.verify(service.ud).writeToFile();
			
		}
		
		@Test
		public void testLogin() {
			String username = "Bob";
			
			service.login(username);
			
			Mockito.verify(service.ud).getUser(username);
		}
		
		@Test
		public void testGetAllUsers() {
			service.getAll();
			Mockito.verify(service.ud).getUsers();
		}
		@Test
		public void testGetCurCollection() {
			 
			
			String username= "Bob";
			User user = (service.ud).getUser(username);
			service.getCurCollection(user);
			Mockito.verify(service.comDAO).getComics();
		}
//		@Test
//		public void testGetUserInfo() {
//			String username= "Bob";
//			
//			System.out.println("username"+username);
//			
//			service.getUserInfo(username);
//			
//			Mockito.verify(service.ud).getUser(username).toString();
//		}
}
