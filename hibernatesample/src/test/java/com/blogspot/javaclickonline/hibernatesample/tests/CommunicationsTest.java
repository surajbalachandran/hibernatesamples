package com.blogspot.javaclickonline.hibernatesample.tests;


import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.Communication;
import com.blogspot.javaclickonline.hibernatesample.domain.User;

public class CommunicationsTest {

	private SessionFactory factory;
	@Before
	public void setup() {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Test
	public void saveUsersWithCommunications() throws Exception {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		User user = new User();
		user.setUserName("lakshmi.suraj");
		user.setFirstName("Lakshmi");
		user.setLastName("Suraj");
		user.setActive(true);
		user.setAge(28);
		user.setDateOfBirth(format.parse("04/09/1983"));
		
		Communication communication = new Communication();
		communication.setBusinessPhoneNo("9496160476");
		communication.setHomePhoneNo("3176606120");
		Communication communication2 = new Communication();
		communication2.setBusinessPhoneNo("9492342322");
		communication2.setHomePhoneNo("3176160222");
		Set<Communication> communications = new HashSet<Communication>();
		communications.add(communication);
		communications.add(communication2);
		user.setCommunications(communications);
		
		session.save(user);
		session.getTransaction().commit();
	}
	
	@Test
	public void deleteUsersWithCommunications() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User where userName = :userName");
		query.setParameter("userName", "lakshmi.suraj");
		User user = (User) query.list().get(0);
		session.delete(user);
		session.getTransaction().commit();
	}

}
