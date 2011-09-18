package com.blogspot.javaclickonline.hibernatesample.tests;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.Role;

public class RoleTests {

	private SessionFactory factory;
	
	@Before
	public void setUp() throws Exception {
	
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Test
	public void saveRole() {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Role adminRole = new Role();
		adminRole.setRoleId(1l);
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		
		Role developerRole = new Role();
		developerRole.setRoleId(2l);
		developerRole.setRoleName("Developer");
		developerRole.setRoleDescription("Developer role");
		
		session.save(adminRole);
		session.save(developerRole);
		session.getTransaction().commit();
	}

	@Test
	public void findRoleByRoleId() {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Role role = (Role) session.load(Role.class, 1l);
		System.out.println(role);
	}
	
	@Test
	public void tearDown() {

		factory.close();
	}
}
