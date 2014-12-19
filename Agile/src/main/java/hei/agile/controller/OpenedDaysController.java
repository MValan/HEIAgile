package hei.agile.controller;

import hei.agile.entity.Book;

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
public class OpenedDaysController {
	private static final Logger logger = LoggerFactory
			.getLogger(OpenedDaysController.class);

	@RequestMapping(value = "/openedDays", method = RequestMethod.GET)
	public String getForm(ModelMap model) {
		logger.debug("Gestion des jours d'ouverture");
		return "/openedDays/OpenedDaysForm";

	}

	@RequestMapping(value = "/openedDays", method = RequestMethod.POST)
	public String addBook(SessionStatus sessionStatus, ModelMap model) {
		
		return "openedDays/openedDaysForm";
	}
}