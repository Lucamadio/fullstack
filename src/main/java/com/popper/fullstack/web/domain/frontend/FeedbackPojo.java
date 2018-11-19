package com.popper.fullstack.web.domain.frontend;

import java.io.Serializable;

public class FeedbackPojo implements Serializable{

	private static final long serialVersionID = 1L;
	
	private String email;
	private String firstName;
	private String lastName;
	private String feedBack;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	@Override
	public String toString() {
		return "FeedbackPOJO [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", feedBack="
				+ feedBack + "]";
	}
	
		
}
