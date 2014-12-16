package hei.agile.controller;

import hei.agile.entity.Book;
import hei.agile.entity.Borrow;
import hei.agile.entity.Member;
import hei.agile.service.BookService;
import hei.agile.service.BorrowService;
import hei.agile.service.MemberService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Named
@RequestMapping("/")
public class BorrowController {

	private static final Logger logger = LoggerFactory
			.getLogger(BorrowController.class);

	@Inject
	private BorrowService borrowService;
	@Inject
	private BookService bookService;
	@Inject
	private MemberService memberService;

	@RequestMapping(value = "/borrow", method = RequestMethod.GET)
	public String getForm(ModelMap model) {
		model.addAttribute("borrow", new Borrow());
		model.addAttribute("books", borrowService.createAutocomplete());
		model.addAttribute("dateRest", borrowService.getBorrowDate());

		logger.debug("On fait de l'autocomplete YOLOWW");

		return "borrow/BorrowBookForm";
	}

	@RequestMapping(value = "/borrow", method = RequestMethod.POST)
	public String addBorrow(HttpServletRequest request, ModelMap model) {

		long idBook = Long.parseLong(request.getParameter("idBook"));
		long idMember = Long.parseLong(request.getParameter("idMember"));

		String dateBorrowEnd = request.getParameter("dateBorrowEnd");
		List<String> errors = new ArrayList<>();

		Book book = bookService.findOne(idBook);

		if (book == null) {
			errors.add("Livre introuvable");
		} else if (borrowService.findBorrowByIdBook(idBook) != null) {
			errors.add("Livre déjà emprunté");
		}

		Member member = memberService.findOne(idMember);
		if (member == null) {
			errors.add("Membre introuvable");
		}

		logger.info("Il y a des erreurs");

				model.addAttribute("errors", errors);
		if (errors.isEmpty()) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date date = formatter.parse(dateBorrowEnd);
				Borrow borrow = new Borrow(book, member, date);
				borrowService.saveBorrow(borrow);
				model.addAttribute(
						"message",
						"Un nouvel emprunt vient d'être réalisé. \n Livre emprunté : "
								+ (borrow.getBook().getTitleBook()) + "\t par "
								+ (borrow.getMember()).getFirstNameMember()
								+ " "
								+ (borrow.getMember()).getLastNameMember());
				model.addAttribute("borrow", new Borrow());
				logger.info("Ajout d'un emprunt : {} par: {} {}",
						(borrow.getBook()).getTitleBook(),
						(borrow.getMember()).getFirstNameMember(),
						(borrow.getMember()).getLastNameMember());

				model.addAttribute("borrow", new Borrow());
				model.addAttribute("books", borrowService.createAutocomplete());
				model.addAttribute("dateRest", borrowService.getBorrowDate());

				logger.debug("On fait de l'autocomplete YOLOWW");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return "borrow/BorrowBookForm";
		} else {
			return "borrow/BorrowBookForm";
		}

	}
	
	@RequestMapping(value = "/return", method = RequestMethod.GET)
	public String getReturnBookForm(ModelMap model) {
		model.addAttribute("borrow", new Borrow());
		model.addAttribute("borrowreturned", new Borrow());
		model.addAttribute("books", borrowService.createAutocomplete());
		return "borrow/ReturnBookForm";

	}

	@RequestMapping(value = "/return/{idmember}", method = RequestMethod.GET)
	public @ResponseBody String showBorrowedBooks(
			@PathVariable("idmember") long idMember) {
		String borrowsbymember = borrowService.findBorrowByIdMember(idMember);
		
		return borrowsbymember;
	}

	@RequestMapping(value = "/returnBook/{idmember}", method = RequestMethod.POST)
	public @ResponseBody String updateBorrows(HttpServletRequest request, ModelMap model, @PathVariable("idmember") long idMember) {
		String [] checkedReturned = request.getParameterValues("returned");
		if(checkedReturned.length > 0){
			for (int i = 0; i < checkedReturned.length; i++) {
				borrowService.setBorrowToReturned(Long.parseLong(checkedReturned[i]));
			}
		}
		String borrowsbymember = borrowService.findBorrowByIdMember(idMember);
		
		return borrowsbymember;
	}
}
