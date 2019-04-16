package org.occ.p3.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="borrow")
public class Borrow  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "gen_borrow", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "gen_borrow", sequenceName = "seq_borrow", allocationSize = 1)
	private Integer id;
	
	private Date startBorrowDate;
	
	private String status;
	
	private Date endBorrowDate;
	
	private boolean extended;

	@OneToOne
	private Book book;
	
	
	private Integer userBorrowingId;
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
 
	
	public Date getStartBorrowDate() {
		return startBorrowDate;
	}

	public void setStartBorrowDate(Date startBorrowDate) {
		this.startBorrowDate = startBorrowDate;
	}

	public Date getEndBorrowDate() {
		return endBorrowDate;
	}

	public void setEndBorrowDate(Date endBorrowDate) {
		this.endBorrowDate = endBorrowDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


 

	public Integer getUserBorrowingId() {
		return userBorrowingId;
	}

	public void setUserBorrowingId(Integer userBorrowingId) {
		this.userBorrowingId = userBorrowingId;
	}

	public boolean isExtended() {
		return extended;
	}

	public void setExtended(boolean extended) {
		this.extended = extended;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
