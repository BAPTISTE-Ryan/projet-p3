package org.occ.p3.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "gen_book", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "gen_book", sequenceName = "seq_book", allocationSize = 1)
	private Integer id;
	
	private boolean available;
	
	private String barcode;
	
	
	
//	@ManyToOne
	private Integer workId;

	
	
	public Integer getWorkId() {
		return workId;
	}



	public void setWorkId(Integer workId) {
		this.workId = workId;
	}



	public Book() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public boolean isAvailable() {
		return available;
	}



	public void setAvailable(boolean available) {
		this.available = available;
	}



	public String getBarcode() {
		return barcode;
	}



	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}




	 

}
