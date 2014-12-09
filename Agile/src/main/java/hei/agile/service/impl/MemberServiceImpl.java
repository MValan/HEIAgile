package hei.agile.service.impl;

import hei.agile.dao.MemberDAO;
import hei.agile.entity.Member;
import hei.agile.service.MemberService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;

@Named
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO memberDAO;

	@Override
	public void saveMember(Member member) {
		
		memberDAO.save(member);
	}

	@Override
	public List<Member> findAll() {
		
		List<Member> members = memberDAO.findAll();
		return members;
	}
	
	@Test
	public void saveMember() {
		
		Date date = new Date(Calendar.THURSDAY);
		Member member = new Member();
		member.setFirstNameMember("firstNameMember");
		member.setLastNameMember("lastNameMember");
		member.setGenderMember("F");
		member.setBirthDateMember(date);
		
		memberDAO.save(member);
		Assert.assertNotNull(memberDAO.getOne(member.getIdMember()));
		Assert.assertEquals(member, memberDAO.getOne(member.getIdMember()));
	}
}
