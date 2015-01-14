package hei.agile.service.impl;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import hei.agile.dao.BorrowDAO;
import hei.agile.entity.Book;
import hei.agile.entity.Borrow;
import hei.agile.entity.Member;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BorrowServiceImplTestCase {

	@InjectMocks
	private BorrowServiceImpl borrowService;
	
	@Mock
	private BorrowDAO borrowDAO;
	
	@Before
	public void configureTests(){
		
		List<Borrow> allBorrows = Arrays.asList(getBorrow1(),getBorrow2());
		when(borrowDAO.findAll()).thenReturn(allBorrows);
	}
	
	@Test
	public void shouldSaveBorrow() {
		
		
		Borrow borrow = getBorrow1();
		
		borrowService.saveBorrow(borrow);
		
		verify(borrowDAO,times(1)).save(eq(borrow));
	}
	
	/*@Test
	public void shouldFindBorrowByIdMember() {
		
		Long idMember = getBorrow1().getMember().getIdMember();		
		borrowService.findBorrowByIdMember(idMember);
		
		verify(borrowDAO,times(1)).findBorrowByIdMember(eq(idMember));
	}
	
	@Test
	public void shouldFindBorrowByIdBook() {
		
		Long idBook = getBorrow1().getBook().getIdBook();		
		borrowService.findBorrowByIdBook(idBook);
		
		verify(borrowDAO,times(1)).findBorrowByIdBook(eq(idBook));
	}*/
	
	@Test
	public void shouldFindOne(){
		
		Long idBorrow = getBorrow1().getIdBorrow();		
		borrowService.findOne(idBorrow);
		
		verify(borrowDAO,times(1)).findOne(eq(idBorrow));
	}
	
	@Test
	public void shouldSetBorrowToReturned(){

		Long idBorrow = getBorrow1().getIdBorrow();	
		borrowDAO.setBorrowToReturned(idBorrow);
		
		verify(borrowDAO,times(1)).setBorrowToReturned(eq(idBorrow));
	}
	
	@Test
	public void shouldSetBorrowToExtended(){
		
		Long idBorrow = getBorrow1().getIdBorrow();
		Calendar calendar = new GregorianCalendar(2015, 1, 25);
		borrowDAO.setBorrowToExtended(calendar.getTime(), idBorrow);
		
		verify(borrowDAO,times(1)).setBorrowToExtended(eq(calendar.getTime()),eq(idBorrow));
	}
	
	private Borrow getBorrow1() {
		
		Member member = new Member();
		Book book = new Book();
		Calendar calendar = new GregorianCalendar(2015, 1, 15);


		Borrow borrow = new Borrow(book, member, calendar.getTime());
		
		return borrow;
	}
	
	private Borrow getBorrow2() {
		
		Member member = new Member();
		Book book = new Book();
		Calendar calendar = new GregorianCalendar(2015, 1, 14);


		Borrow borrow = new Borrow(book, member, calendar.getTime());
		
		return borrow;
	}
}
