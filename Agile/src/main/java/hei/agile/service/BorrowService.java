package hei.agile.service;

import hei.agile.entity.Borrow;

import java.util.List;

public interface BorrowService {

	public String createAutocomplete();

	public String getBorrowDate();

	public void saveBorrow(Borrow borrow);

	public Borrow findBorrowByIdBook(long idBook);

	public List<Borrow> findBorrowByIdMember(long idMember);
}