package com.blogspot.javaclickonline.hibernatesample.tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.Role;
import com.blogspot.javaclickonline.hibernatesample.domain.User;

public class UserRoleTests {

	private SessionFactory factory;
	
	@Before
	public void setUp() {
		
		// set up the session factory.
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Test
	public void saveUsersRoles() throws Exception {
		
		// Save some users.
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		User user = findUsersByUserName("suraj.balachandran");
		Role role = findRolesByRoleId(2l);
		
		Set<Role> userRoles = new HashSet<Role>();
		userRoles.add(role);
		user.setUserRoles(userRoles);
		
		session.save(user);
		session.getTransaction().commit();
	}
	
	private User findUsersByUserName(String userName) {
		
		// Find some users.
		Session session = factory.getCurrentSession();
		
		Query query = session.createQuery("from User where userName = :userName");
		query.setParameter("userName", userName);
		List<User> users = query.list();
		
		User user = users.get(0);
		return user;
	}
	
	private Role findRolesByRoleId(Long roleId) {
		
		// Find some users.
		Session session = factory.getCurrentSession();
		
		Role role = (Role) session.load(Role.class, roleId);
		
		return role;
	}
	
	@After
	public void tearDown() {
		
		// close the session factory.
		factory.close();
	}
}
