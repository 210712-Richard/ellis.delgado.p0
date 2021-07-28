package com.revature.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.revature.beans.*;
import com.revature.data.*;

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
			}
		
		@Test
		public void testRegistration() {
			String username = "Bob";
			String email = "bbob@gmail.com";
			String superhero = "Bob";
			String comic = "Bob Attacks";
			
			service.register(username, email, superhero, comic);
			
			ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
			Mockito.verify(service.ud).addUser(captor.capture());
			Mockito.verify(service.ud).writeToFile();
			
		}
}
