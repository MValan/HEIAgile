package hei.agile.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import hei.agile.entity.Member;
import hei.agile.service.MemberService;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Named
@RequestMapping("/")
public class IndexController {

	private static final Logger logger = LoggerFactory
			.getLogger(IndexController.class);

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String getForm(ModelMap model) {

		logger.debug("Affichage de la page d'accueil");

		return "index";
	}
}
