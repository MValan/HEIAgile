package hei.agile.service;

import hei.agile.entity.Book;
import java.util.List;

public interface BookService {
	public List<Book> findAll();
	public Book findOne(long idBook);

	public List<Book> findAllAvailable();
	
	public void saveBook(Book book);
}