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
public class BorrowController {
	
	private static final Logger logger = LoggerFactory.getLogger(BorrowController.class);
	
	@Inject
    private BorrowService borrowService;
	
	@RequestMapping(value="/borrow",method = RequestMethod.GET)
    public String getForm(ModelMap model) {
				
		model.addAttribute("books", borrowService.listBooksName());		
		logger.debug("On fait de l'autocomplete YOLOWW");
		
        return "borrow/BorrowBookForm";
    }
}
