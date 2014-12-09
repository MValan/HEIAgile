package hei.agile.service.impl;

import hei.agile.dao.MemberDAO;
import hei.agile.entity.Member;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;

@Transactional
public class MemberServiceImplTestCase {

	@Inject
	private MemberDAO memberDAO;
	
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
