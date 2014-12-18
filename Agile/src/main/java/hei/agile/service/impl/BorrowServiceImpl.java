package hei.agile.service.impl;

import hei.agile.dao.BookDAO;
import hei.agile.dao.BorrowDAO;
import hei.agile.dao.MemberDAO;
import hei.agile.entity.Book;
import hei.agile.entity.Borrow;
import hei.agile.entity.Member;
import hei.agile.service.BorrowService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.google.gson.Gson;

@Named
@Transactional
public class BorrowServiceImpl implements BorrowService {

	@Inject
	private BorrowDAO borrowDAO;

	@Inject
	private BookDAO bookDAO;

	@Inject
	private MemberDAO memberDAO;

	public String createAutocomplete() {

		String script = null;
		List<Book> allBooks = bookDAO.findAllAvailable();
		List<Member> allMembers = memberDAO.findAll();
		// Get all books
		int i = 0;
		String availableBooks = "";
		for (Book book : allBooks) {
			if (i != 0) {
				availableBooks = availableBooks + ",";
			}
			availableBooks = availableBooks + "{label:\"" + book.getTitleBook()
					+ "\", value:" + book.getIdBook() + "}";
			i++;
		}

		int j = 0;
		String availableMembers = "";
		for (Member member : allMembers) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			if (j != 0) {
				availableMembers = availableMembers + ",";
			}
			availableMembers = availableMembers + "{label:\""
					+ member.getLastNameMember() + "_"
					+ member.getFirstNameMember() + " "
					+ df.format(member.getBirthDateMember()) + "\", value:"
					+ member.getIdMember() + "}";
			j++;
		}
		script = "<script type='text/javascript'>\n";

		script += "var availableBooks = [" + availableBooks + "];\n";
		script += "$(\"#titleBook\").autocomplete({change: function(event, ui){checkTitle(ui.item.label);},source: availableBooks, focus: function(event,ui ) {$(\"#titleBook\").val(ui.item.label);return false;},select: function(event, ui) {$(\"#titleBook\").val(ui.item.label);$(\"#titleBook\").attr(\"data-value\",ui.item.value);$(\"#idBook\").val(ui.item.value);return false;}});\n";
		script += "var availableMembers = [" + availableMembers + "];\n";
		script += "$(\"#membreBorrow\").autocomplete({change: function(event, ui){checkMember(ui.item.label);},source: availableMembers, focus: function(event,ui ) {$(\"#membreBorrow\").val(ui.item.label);return false;},select: function(event, ui) {$(\"#membreBorrow\").val(ui.item.label);$(\"#membreBorrow\").attr(\"data-value\",ui.item.value);$(\"#idMember\").val(ui.item.value);return false;}});\n";
		script += "console.log(availableBooks);\n";
		script += "</script>\n";
		getBorrowDate();
		return script;
	}

	public String getBorrowDate() {
		Date today = new Date();
		SimpleDateFormat FormattedDATE = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DATE, 21);
		return (FormattedDATE.format(c.getTime()));
	}
	
	public Date extendBorrowDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 21);
		return (c.getTime());
	}


	public Borrow findBorrowByIdBook(long idBook) {
		return borrowDAO.findByBook_IdBook(idBook);
	}

	public void saveBorrow(Borrow borrow) {
		borrowDAO.save(borrow);
	}
	
	public String findBorrowByIdMember(long idMember) {
		Gson gson = new Gson();
		List<Borrow> borrowsbymember = new ArrayList<Borrow>();

		for (Borrow borrow : borrowDAO.findByMember_IdMember(idMember)) {
			if(!borrow.isReturned()){
				borrowsbymember.add(new Borrow(borrow.getIdBorrow(),new Book(borrow.getBook().getIdBook(), borrow.getBook().getIsbn(), borrow.getBook().getTitleBook(), borrow.getBook().getPriceBook()), new Member(borrow.getMember().getLastNameMember(), borrow.getMember().getFirstNameMember(), borrow.getMember().getGenderMember(), borrow.getMember().getBirthDateMember()), borrow.getDateBorrowEnd(), borrow.isExtended()));
			}
		}
		return gson.toJson(borrowsbymember);
	}
	
	public Borrow findOne(long idBorrow) {
		return borrowDAO.findOne(idBorrow);
	}
	
	public void setBorrowToReturned(Long idBorrow){
		borrowDAO.setBorrowToReturned(idBorrow);
	}
	
	public void setBorrowToExtended(Long idBorrow, Date dateBorrowEnd){
		borrowDAO.setBorrowToExtended(dateBorrowEnd, idBorrow);
	}
	
}
