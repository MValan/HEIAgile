package hei.agile.entity;

import java.util.Date;

import javax.persistence.Column;
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

	@ManyToOne
	@JoinColumn(name = "idBook")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "idMember")
	private Member member;
	
	@Column(name = "dateBorrowEnd")
	private Date dateBorrowEnd;
	
	@Column(name="returned")
	private boolean returned;

	public Borrow(Book book, Member member, Date dateBorrowEnd) {
		super();
		this.book = book;
		this.member = member;
		this.dateBorrowEnd = dateBorrowEnd;
	}

	public Borrow(long idBorrow, Book book, Member member, Date dateBorrowEnd) {
		super();
		this.idBorrow = idBorrow;
		this.book = book;
		this.member = member;
		this.dateBorrowEnd = dateBorrowEnd;
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

	public Date getDateBorrowEnd() {
		return dateBorrowEnd;
	}

	public void setDateBorrowEnd(Date dateBorrowEnd) {
		this.dateBorrowEnd = dateBorrowEnd;
	}
	
	
}
