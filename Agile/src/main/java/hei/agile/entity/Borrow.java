package hei.agile.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBook")
	private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMember")
	private Member member;

	public Borrow(Book book, Member member) {
		super();
		this.book = book;
		this.member = member;
	}

	public Borrow() {
		super();
		// ICI System.out.println("iciii");
	}

	public long getIdBorrow() {
		return idBorrow;
	}

	public void setIdBorrow(long idBorrow) {
		this.idBorrow = idBorrow;
	}
	
	public Book getBook() {
		// ICI System.out.println("iciii");
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		// ICI System.out.println("iciii");
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
