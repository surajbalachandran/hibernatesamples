package com.blogspot.javaclickonline.hibernatesample.tests;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.blogspot.javaclickonline.hibernatesample.domain.Event;

public class EventTests {

	private SessionFactory factory;
	@Before
	public void setup() {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Test
	public void saveEvents() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Event event = new Event();
		event.setEventName("Onam celebrations - 09/17");
		event.setEventDescription("Onam Celebrations Sep 17th, 2011");
		
		session.save(event);
		session.getTransaction().commit();
		
		session = factory.openSession();
		Query query = session.createQuery("from Event e where e.eventName = :eventName");
		query.setParameter("eventName", "Onam celebrations - 09/17");
		List<Event> eventsList = query.list();

		List<String> eventsStrList = new ArrayList<String>();
		for(Event indEvent : eventsList) {
			
			eventsStrList.add(indEvent.toString());
		}
		assertThat(eventsStrList, hasItems("Event[id:1, name:Onam celebrations - 09/17, description:Onam Celebrations Sep 17th, 2011]"));
	}
}
