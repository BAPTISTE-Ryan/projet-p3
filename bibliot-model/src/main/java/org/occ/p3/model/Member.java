package org.occ.p3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="member")
@PrimaryKeyJoinColumn(name = "id")
public class Member extends User {

	private String name;
    private String emailadress;
    private Date birthdate;
    private String address;
    private String profilePicture;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailadress() {
		return emailadress;
	}
	public void setEmailadress(String emailadress) {
		this.emailadress = emailadress;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

}
