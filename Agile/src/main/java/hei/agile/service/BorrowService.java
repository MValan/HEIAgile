package hei.agile.service;

import java.util.Date;

import hei.agile.entity.Borrow;

public interface BorrowService {

	public String createAutocomplete();

	public String getBorrowDate();
	
	public Date extendBorrowDate(Date date);

	public void saveBorrow(Borrow borrow);

	public Borrow findBorrowByIdBook(long idBook);

	public String findBorrowByIdMember(long idMember);
	
	public Borrow findOne(long idBorrow);
	
	public void setBorrowToReturned(Long idBorrow);
	
	public void setBorrowToExtended(Long idBorrow, Date dateBorrowEnd);
}