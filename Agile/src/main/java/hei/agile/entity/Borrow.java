package hei.agile.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idBorrow;

	private boolean returned;

	@ManyToOne
	@JoinColumn(name = "idBook")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "idMember")
	private Member member;

	public Borrow(Book book, Member member) {
		super();
		this.book = book;
		this.member = member;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}
}
