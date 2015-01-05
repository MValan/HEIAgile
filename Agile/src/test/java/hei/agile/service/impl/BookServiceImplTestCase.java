package hei.agile.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import hei.agile.dao.BookDAO;
import hei.agile.entity.Book;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTestCase {

	@InjectMocks
	private BookServiceImpl bookService;
	
	@Mock
	private BookDAO bookDAO;
	
	@Before
	public void configureTests(){
		
		List<Book> allBooks = Arrays.asList(getBook1(),getBook2());
		when(bookDAO.findAll()).thenReturn(allBooks);
	}
	
	@Test
	public void shouldSaveMember() {
		
		Book book = getBook1();
		
		bookService.saveBook(book);
		
		verify(bookDAO,times(1)).save(eq(book));
	}

	
	@Test
	public void shouldListAll(){
		
		List<Book> allBooks = bookService.findAll();
		
		assertThat(allBooks).hasSize(2);
		assertThat(allBooks).extracting("idBook", "isbn", "titleBook", "priceBook").containsOnly(tuple((long)1, "55555555", "book1", (float)20),tuple((long)2, "66666666", "book2", (float)30));
	}
	
	@Test
	public void shouldFindOne(){
		
		/*Long idBook = getBook1().getIdBook();
		
		Book book = bookService.findOne(idBook);
		
		assertThat(book).isNotNull();
		assertThat(book.getIdBook()).isEqualTo(idBook);*/
	}
	
	@Test
	public void shouldFindAllAvailable(){
		
		List<Book> listBooksAvailable = bookService.findAllAvailable();
		
		assertThat(listBooksAvailable).isNullOrEmpty();
	}
	
	private Book getBook1() {
		
		Book book = new Book();
		
		book.setIdBook(1);
		book.setIsbn("55555555");
		book.setPriceBook((float)20);
		book.setTitleBook("book1");
		
		return book;
	}
	
	private Book getBook2() {
		
		Book book = new Book();
		
		book.setIdBook(2);
		book.setIsbn("66666666");
		book.setPriceBook((float)30);
		book.setTitleBook("book2");
		
		return book;
	}
}
