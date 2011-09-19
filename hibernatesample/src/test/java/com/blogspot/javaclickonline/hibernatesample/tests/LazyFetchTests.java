package com.blogspot.javaclickonline.hibernatesample.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.User;

public class LazyFetchTests {

	private SessionFactory factory;
	
	@Before
	public void setUp() {
		
		// set up the session factory.
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Test
	public void testLazyFetch1() {
		
		// By default, it is lazy fetching. So for this example, I made user events eager fetching
		// For now comment lazy=false in User.hbm.xml. Make true before running this test.
		Session session = factory.openSession();
		session.beginTransaction();
		
		User user1 = (User) session.load(User.class, 1l);
		System.out.println(user1);
		
		User user2 = (User) session.load(User.class, 2l);
		System.out.println(user2);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testLazyFetch2() {
		
		// By default, it is lazy fetching. So for this example, I made user events eager fetching
		// For now comment lazy=false in User.hbm.xml. Make true before running this test.
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User");
		List<User> users = query.list();
		
		for(User user : users) {
			
			System.err.println(user);
		}
		session.getTransaction().commit();
	}
}
