package hei.agile.controller;

import hei.agile.entity.Member;
import hei.agile.service.MemberService;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@RequestMapping(value = "/addMember", method = RequestMethod.GET)
	public String getForm(ModelMap model) {

		model.addAttribute("member", new Member());
		logger.debug("Creation d'un membre");

		return "members/AddMemberForm";
	}

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addMember(@ModelAttribute("member") Member member,
			SessionStatus sessionStatus) {

		logger.info("Ajout du membre : Nom:{} Prenom:{} Sexe:{} DateNaiss:{}",
				member.getNameMember(), member.getNicknameMember(),
				member.getGenderMember(), member.getBirthDateMember());
		memberService.saveMember(member);
		sessionStatus.setComplete();

		return "members/AddMemberForm";
	}
}
