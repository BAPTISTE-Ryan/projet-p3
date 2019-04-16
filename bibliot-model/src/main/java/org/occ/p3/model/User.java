package org.occ.p3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	@Id
	@GeneratedValue(generator = "gen_user", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "gen_user", sequenceName = "seq_user", allocationSize = 1)
	 
	private Integer id;
	
	private String userName;
	
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Borrow> borrow;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Borrow> getBorrow() {
		return borrow;
	}
	
	public Integer getCurrentBorrows() {
		Integer count=0;
		for (int i = 0; i < borrow.size(); i++) {
			if (borrow.get(i).getStatus().equals("ENCOURS") || borrow.get(i).getStatus().equals("EXTENDED")) {
				count++;
			}
		}
		return count;
	}

	public void setBorrow(List<Borrow> borrow) {
		this.borrow = borrow;
	}
	
}
