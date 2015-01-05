package hei.agile.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hei.agile.dao.ClosedDaysDAO;
import hei.agile.dao.OpenedDaysDAO;
import hei.agile.entity.Borrow;
import hei.agile.entity.ClosedDays;
import hei.agile.entity.OpenedDays;
import hei.agile.service.ClosedDaysService;
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
	private ClosedDaysService closedDaysService;
	
	@Inject
	private OpenedDaysDAO openedDaysDAO;
	
	@Inject
	private ClosedDaysDAO closedDaysDAO;

	@RequestMapping(value = "/openedDays", method = RequestMethod.GET)
	public String getForm(ModelMap model) {
		logger.debug("Gestion des jours d'ouverture");
		model.addAttribute("allDays", openedDaysService.generateHtmlDaysTable());
		
		String scriptClosedDates = openedDaysService.generateScriptClosedDays();
		model.addAttribute("closedDates", scriptClosedDates);
		
		model.addAttribute("allClosedDays", openedDaysService.generateHtmlClosedDaysTable());
		
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
	
	@RequestMapping(value = "/addNewClosedDay", method = RequestMethod.POST)
	public @ResponseBody String addNewClosedDay(HttpServletRequest request, ModelMap model) {
		String closedDays = request.getParameter("closedDate");
		closedDaysDAO.deleteAll();
		//On décompose la chaine de caractère pour créer les dates
		for (int i = 0; i < closedDays.length(); i+=12) {
			String tempString = closedDays.substring(i, i+10);
			System.out.println(tempString);
			
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			Date date;
			try {
				date = formatter.parse(tempString);
				closedDaysService.saveClosedDays(new ClosedDays(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		String allClosedDays = openedDaysService.generateHtmlClosedDaysTable();
		
		//List<OpenedDays> allDays = openedDaysDAO.findAll();
		
		Gson gson = new Gson();
		
		return gson.toJson(allClosedDays);
	}
}