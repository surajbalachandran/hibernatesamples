package com.blogspot.javaclickonline.hibernatesample.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.User;

public class SecondaryLevelCacheTests {

	private SessionFactory factory;
	@Before
	public void setup() {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Test
	public void testSecondaryLevelCache() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		User user1 = (User) session.load(User.class, 1l);
		System.out.println(user1);
		
		User user2 = (User) session.load(User.class, 2l);
		System.out.println(user2);
		
		session.getTransaction().commit();
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		User user3 = (User) session.load(User.class, 1l);
		System.out.println(user3);
		
		User user4 = (User) session.load(User.class, 2l);
		System.out.println(user4);
		
		session.getTransaction().commit();
	}
}
