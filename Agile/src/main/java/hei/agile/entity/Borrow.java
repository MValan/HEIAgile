package hei.agile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idBorrow;
	
	@Column (name="idBook")
	private long idBook;

	public Borrow(long idBorrow, long idBook) {
		super();
		this.idBorrow = idBorrow;
		this.idBook = idBook;
	}

	public Borrow() {
		super();
	}

	public long getIdBorrow() {
		return idBorrow;
	}

	public void setIdBorrow(long idBorrow) {
		this.idBorrow = idBorrow;
	}

	public long getIdBook() {
		return idBook;
	}

	public void setIdBook(long idBook) {
		this.idBook = idBook;
	}
	
	
}
