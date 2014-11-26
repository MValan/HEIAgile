package hei.agile.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idBook;
	
	@Column (name="titleBook")
	private String titleBook;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="book")
	private List<Borrow> borrow;

	public Book(long idBook, String titleBook) {
		super();
		this.idBook = idBook;
		this.titleBook = titleBook;
	}

	public Book() {
		super();
	}

	public long getIdBook() {
		return idBook;
	}

	public void setIdBook(long idBook) {
		this.idBook = idBook;
	}

	public String getTitleBook() {
		return titleBook;
	}

	public void setTitleBook(String titleBook) {
		this.titleBook = titleBook;
	}
	
	
	
}
