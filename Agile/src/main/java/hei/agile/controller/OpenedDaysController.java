package hei.agile.controller;

import java.util.List;

import hei.agile.dao.OpenedDaysDAO;
import hei.agile.entity.Borrow;
import hei.agile.entity.OpenedDays;
import hei.agile.service.OpenedDaysService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;

@Controller
@Named
@RequestMapping("/")
public class OpenedDaysController {
	private static final Logger logger = LoggerFactory
			.getLogger(OpenedDaysController.class);
	
	@Inject
	private OpenedDaysService openedDaysService;
	
	@Inject
	private OpenedDaysDAO openedDaysDAO;

	@RequestMapping(value = "/openedDays", method = RequestMethod.GET)
	public String getForm(ModelMap model) {
		logger.debug("Gestion des jours d'ouverture");
		model.addAttribute("allDays", openedDaysService.generateHtmlDaysTable());
		
		return "/openedDays/OpenedDaysForm";

	}

	@RequestMapping(value = "/openedDays", method = RequestMethod.POST)
	public String addBook(SessionStatus sessionStatus, ModelMap model) {
		
		return "openedDays/openedDaysForm";
	}
	
	@RequestMapping(value = "/addNewOpenDay", method = RequestMethod.POST)
	public @ResponseBody String addNewDay(HttpServletRequest request, ModelMap model) {
		String day = request.getParameter("input-days");
		String from = request.getParameter("openHour");
		String to = request.getParameter("closeHour");
		
		openedDaysService.saveOpenedDays(new OpenedDays(day, from, to));
		
		List<OpenedDays> allDays = openedDaysDAO.findAll();
		
		Gson gson = new Gson();
		
		return gson.toJson(allDays);
	}
}