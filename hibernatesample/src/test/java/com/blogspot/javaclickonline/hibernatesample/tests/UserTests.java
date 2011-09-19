/**
 * 
 */
package com.blogspot.javaclickonline.hibernatesample.tests;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.User;

/**
 * @author suraj.balachandran
 *
 */
public class UserTests {

	private SessionFactory factory;
	
	@Before
	public void setUp() {
		
		// set up the session factory.
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Test
	public void saveUsers() throws Exception {
		
		// Save some users.
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		User user = new User();
		user.setUserName("suraj.balachandran");
		user.setFirstName("Suraj");
		user.setLastName("Balachandran");
		user.setDateOfBirth(format.parse("01/09/1981"));
		user.setAge(30);
		user.setActive(true);
		session.save(user);
		
		User user1 = new User();
		user1.setUserName("aarush.suraj");
		user1.setFirstName("Aarush");
		user1.setLastName("Suraj");
		user1.setDateOfBirth(format.parse("04/28/2011"));
		user1.setAge(0);
		user1.setActive(true);
		session.save(user1);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void findUsers() {
		
		// Find some users.
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		
		for(User user : users) {
			
			System.err.println(user);
		}
		
		session.getTransaction().commit();
	}

	@After
	public void tearDown() {
		
		// close the session factory.
		factory.close();
	}
	
	
}
