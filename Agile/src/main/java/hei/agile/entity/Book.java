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
	
	@Column (name="ISBN")
	private String isbn;
	
	@Column (name="PriceBook")
	private Float priceBook;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="book")
	private List<Borrow> borrow;

	public Book(long idBook, String isbn, String titleBook, Float priceBook) {
		this.idBook = idBook;
		this.isbn = isbn;
		this.titleBook = titleBook;
		this.priceBook = priceBook;
	}

	public Book() {
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
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Float getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(Float priceBook) {
		this.priceBook = priceBook;
	}
	
}
