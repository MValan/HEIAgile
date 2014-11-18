package hei.agile.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.google.gson.Gson;

import hei.agile.dao.BookDAO;
import hei.agile.dao.BorrowDAO;
import hei.agile.entity.Book;
import hei.agile.service.BorrowService;

@Named
@Transactional
public class BorrowServiceImpl implements BorrowService {

	@Inject
	private BorrowDAO borrowDAO;	
	
	@Inject
	private BookDAO bookDAO;	
	
	
public String listBooksName(){
		
		String script = null;
		List<Book> allBooks = bookDAO.findAll();
		//Get all books
		String[] allBooksTitle = new String[allBooks.size()];
		//We only wants the name of the book
		int i = 0;
		for (Book book : allBooks) {
			allBooksTitle[i] = book.getTitleBook();
			i++;
		}
		//Sort names from books
		
				
				String json = new Gson().toJson(allBooksTitle);
				
				script = "<script>\n";
				script += "$( document ).ready(function() {\n";
				script += "$(\"#booksListe\").html('"+json+"');\n";
				script += "var availableTags = "+json+";\n";
				script += "$(\"#titleBook\").autocomplete({source: availableTags, minLength: 3});\n";
				script += "});\n";
				script += "</script>\n";
				
		//Generate new Json Script, to autocomplete the form
		
		return script;
				
				
				
		
		
	}

}
