package com.blogspot.javaclickonline.hibernatesample.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.Dealership;
import com.blogspot.javaclickonline.hibernatesample.domain.Location;

public class InheritanceTests {

	private SessionFactory factory;
	@Before
	public void setup() {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Test
	public void createDealerships() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Dealership dealership = new Dealership();
		dealership.setCustomerName("Tom Wood Nissan");
		dealership.setCustomerType("DEALERSHIP");
		dealership.setDbaName("H&I Tom Wood Nissan");
		dealership.setDealerNo("02345");
		
		session.save(dealership);
		session.getTransaction().commit();
	}
	
	@Test
	public void createLocations() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Location location = new Location();
		location.setCustomerName("Atlanta Auction");
		location.setCustomerType("LOCATION");
		location.setLocationName("SB Atlanta Auction");
		location.setLocationNo("12");
		
		session.save(location);
		session.getTransaction().commit();
	}
}
