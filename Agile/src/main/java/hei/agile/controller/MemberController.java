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
public class MemberController {

	private static final Logger logger = LoggerFactory
			.getLogger(MemberController.class);

	@Inject
	private MemberService memberService;

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public String getForm(ModelMap model) {

		model.addAttribute("member", new Member());
		logger.debug("Creation d'un membre");

		return "members/AddMemberForm";
	}

	@RequestMapping(value = "/members", method = RequestMethod.POST)
	public String addMember(@ModelAttribute("member") Member member,
			SessionStatus sessionStatus, ModelMap model) {

		List<String> errors = new ArrayList<>();

		if (member.getFirstNameMember().equals("")) {
			logger.info("Le prénom n'est pas renseigné");
			errors.add("Le prénom n'est pas renseigné");
		}

		/*
		SimpleDateFormat FormattedDATE = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(member.getBirthDateMember());
		System.out.println(FormattedDATE.format(c.getTime()));
		
		if (FormattedDATE.format(c.getTime()).equals("1970-01-01")) {
			logger.info("La date de naissance n'est pas renseignée");
			errors.add("La date de naissance n'est pas renseignée");
		}
		*/
		if (member.getGenderMember() == null) {
			logger.info("Le genre n'est pas renseigné");
			errors.add("Le genre n'est pas renseigné");
		}
		if (member.getLastNameMember().equals("")) {
			logger.info("Le nom n'est pas renseigné");
			errors.add("Le nom n'est pas renseigné");
		}

		if (errors.isEmpty()) {
			if (!memberService.memberAlreadyExist(member)) {
				logger.info(
						"Ajout du membre : Nom:{} Prenom:{} Sexe:{} DateNaiss:{}",
						member.getLastNameMember(),
						member.getFirstNameMember(), member.getGenderMember(),
						member.getBirthDateMember());
				memberService.saveMember(member);
				sessionStatus.setComplete();
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String formattedDate = formatter.format(member.getBirthDateMember()); 
				
				model.addAttribute("message",
						"Le membre " + member.getLastNameMember() + " "
								+ member.getFirstNameMember() + " née le "
								+ formattedDate
								+ " a bien été ajouté.");
				model.addAttribute("member", new Member());
			} else {
				logger.info(
						"Le membre : Nom:{} Prenom:{} Sexe:{} DateNaiss:{} existe déjà.",
						member.getLastNameMember(),
						member.getFirstNameMember(), member.getGenderMember(),
						member.getBirthDateMember());
				model.addAttribute("errors", "Le membre existe déjà.");
			}
		} else {
			model.addAttribute("errors", errors);

		}
		// return "redirect:/members/addMember";
		return "members/AddMemberForm";

	}
}
