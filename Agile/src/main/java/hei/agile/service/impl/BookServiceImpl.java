package hei.agile.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import hei.agile.dao.BookDAO;
import hei.agile.entity.Book;
import hei.agile.service.BookService;


@Named
@Transactional
public class BookServiceImpl implements BookService {

	@Inject
	private BookDAO bookDAO;
	
	public List<Book> findAll() {
			return bookDAO.findAll();
	}

	@Override
	public Book findOne(long idBook) {
		return bookDAO.findOne(idBook);
	}
}
