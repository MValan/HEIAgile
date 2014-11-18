package hei.agile.controller;

import hei.agile.service.BorrowService;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Named
@RequestMapping("/")
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Inject
    private BorrowService bookService;
	
	@RequestMapping(value="/book",method = RequestMethod.GET)
    public String getForm(ModelMap model) {
				
		model.addAttribute("book", "test");		
		logger.debug("Ici, test book");
		
        return "borrow/BorrowBookForm";
    }
}
