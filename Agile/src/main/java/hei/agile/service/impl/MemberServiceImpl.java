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
	

}
