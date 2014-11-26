package hei.agile.controller;

import hei.agile.entity.Book;
import hei.agile.service.BookService;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Named
@RequestMapping("/")
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Inject
    private BookService bookService;
	
	@RequestMapping(value="/books",method = RequestMethod.GET)
    public String getForm(ModelMap model) {
				
		model.addAttribute("book", new Book());		
		logger.debug("Création d'un ouvrage");
		
        return "books/AddBook";
    }
	
	@RequestMapping(value="/books", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book,
			SessionStatus sessionStatus){
		logger.info("Ajout de l'ouvrage : ISBN :{} Titre :{} Prix d'achat:{}",book.getIsbn(),book.getTitleBook(),book.getPriceBook());
		bookService.saveBook(book);
		sessionStatus.setComplete();
		
		return "redirect:/books/books";	
	}
}
