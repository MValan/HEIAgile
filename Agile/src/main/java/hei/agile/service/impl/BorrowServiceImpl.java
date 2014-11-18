package hei.agile.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
		int i = 0;
		String availableTags = "";
		for (Book book : allBooks) {
			if(i !=0){
				availableTags = availableTags +",";
			}
			availableTags = availableTags +"{label:\""+book.getTitleBook()+"\", value:"+book.getIdBook()+"}";
			i++;
		}
		
				
				script = "<script>\n";
				script += "$( document ).ready(function() {\n";
				script += "$(\"#booksListe\").html('"+availableTags+"');\n";
				script += "var availableTags = ["+availableTags+"];\n";
				script += "$(\"#titleBook\").autocomplete({source: availableTags, focus: function(event,ui ) {$(\"#titleBook\").val(ui.item.label);return false;},select: function(event, ui) {$(\"#titleBook\").val(ui.item.label);$(\"#titleBook\").attr(\"data-value\",ui.item.value);return false;}});\n";
				script += "});\n";
				script += "$(\"#getValue\").click(function(){alert($(\"#titleBook\").attr(\"data-value\"));});\n";
				script += "</script>\n";
		
		return script;
				
				
				
		
		
	}

}
