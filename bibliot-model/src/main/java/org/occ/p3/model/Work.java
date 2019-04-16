package org.occ.p3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="work")
public class Work {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "gen_work", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "gen_work", sequenceName = "seq_work", allocationSize = 1)
	private Integer id;
	private String author;
	private Integer publicationyear;
	private String type;
	private String title;
	private String description;
	private String coverimageurl;
	
	@OneToOne
	private Library library;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Book> book;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublicationyear() {
		return publicationyear;
	}

	public void setPublicationyear(Integer publicationyear) {
		this.publicationyear = publicationyear;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public String getCoverimageurl() {
		return coverimageurl;
	}

	public void setCoverimageurl(String coverimageurl) {
		this.coverimageurl = coverimageurl;
	}
	
	
	
}
