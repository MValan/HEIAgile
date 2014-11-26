package hei.agile.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import hei.agile.dao.MemberDAO;
import hei.agile.entity.Member;
import hei.agile.service.MemberService;

@Named
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Inject
<<<<<<< HEAD
	private MemberDAO memberDAO;

	@Override
	public void saveMember(Member member) {
		
		memberDAO.save(member);
	}

	@Override
	public List<Member> findAll() {
		
		List<Member> members = memberDAO.findAll();
		return members;
=======
	private MemberDAO membreDAO;

	public void saveMember(Member member) {
		
		membreDAO.save(member);
	}
	
	public List<Member> findAll() {
		return membreDAO.findAll();
	}
	
	@Override
	public Member findOne(long idMember) {
		return membreDAO.findOne(idMember);
>>>>>>> borrowing_books
	}

}
