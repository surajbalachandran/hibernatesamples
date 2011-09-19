/**
 * 
 */
package com.blogspot.javaclickonline.hibernatesample.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author suraj.balachandran
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -3200513566129528082L;
	
	private Long userId;
	private String userName;
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer age;
	private Date dateOfBirth;
	private Boolean active;
	private Set<Role> userRoles;
	private Set<String> emails;
	private Set<Event> events;
	private Set<Communication> communications;
	
	/**
	 * @return the communications
	 */
	public Set<Communication> getCommunications() {
		return communications;
	}

	/**
	 * @param communications the communications to set
	 */
	public void setCommunications(Set<Communication> communications) {
		this.communications = communications;
	}

	/**
	 * @return the events
	 */
	public Set<Event> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public User() {
		
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the active
	 */
	public Boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	/**
	 * @return the userRoles
	 */
	public Set<Role> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {

		return "User[userId:"+this.userId+",userName:"+this.userName+"]";
	}
}
