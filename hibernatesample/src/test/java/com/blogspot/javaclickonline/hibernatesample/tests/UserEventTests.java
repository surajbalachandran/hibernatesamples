package com.blogspot.javaclickonline.hibernatesample.tests;


import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.Event;
import com.blogspot.javaclickonline.hibernatesample.domain.User;

public class UserEventTests {

	private SessionFactory factory;
	@Before
	public void setup() {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}

	@Test
	public void saveUserEvents() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		User user = (User) session.load(User.class, 1l);
		Event event = (Event) session.load(Event.class, 1l);
		Set<Event> events = new HashSet<Event>();
		events.add(event);
		user.setEvents(events);
		
		session.getTransaction().commit();
	}

	@Test
	public void findUserThroughEvents() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Event event = (Event) session.load(Event.class, 1l);
		
		Set<User> users = event.getUsers();
		for(User indUser : users) {
			
			System.err.println(indUser);
			assertEquals(indUser.toString(), "User[userId:1,userName:suraj.balachandran]");
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void findUserThroughEvents2() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		User user = (User) session.load(User.class, 1l);
		
		Set<Event> events = user.getEvents();
		for(Event event : events) {
			Set<User> users = event.getUsers();
			for(User indUser : users) {
				
				assertEquals(indUser.toString(), "User[userId:1,userName:suraj.balachandran]");
			}
		}
		session.getTransaction().commit();
	}
}
