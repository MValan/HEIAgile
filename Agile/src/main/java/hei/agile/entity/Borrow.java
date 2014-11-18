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
    @JoinColumn(name = "idBook", nullable = false)
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMember", nullable = false)
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
	
	
}
