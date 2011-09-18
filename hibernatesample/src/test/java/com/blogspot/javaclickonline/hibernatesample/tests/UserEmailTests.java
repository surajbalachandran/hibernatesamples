package com.blogspot.javaclickonline.hibernatesample.tests;

import java.util.HashSet;
import java.util.Set;
import static org.junit.matchers.JUnitMatchers.*;
import static org.junit.Assert.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.User;


public class UserEmailTests {

	private SessionFactory factory;
	@Before
	public void setup() {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Test
	public void testUserEmail() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		User user = (User) session.load(User.class, 1l);
		Set<String> emails = user.getEmails();
		if(null == emails) {
			
			emails = new HashSet<String>();
		}
		emails.add("suraj.balachandran@gmail.com");
		user.setEmails(emails);
		session.getTransaction().commit();
		
		session = factory.openSession();
		user = (User) session.load(User.class, 1l);
		assertThat(user.getEmails(), hasItems("suraj.balachandran@gmail.com"));
	}
}
