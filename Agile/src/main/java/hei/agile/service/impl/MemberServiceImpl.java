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
	private MemberDAO memberDAO;

	@Override
	public void saveMember(Member member) {
		memberDAO.save(member);
	}

	@Override
	public List<Member> findAll() {
		return memberDAO.findAll();
	}
	
	@Override
	public Member findOne(long idMember) {
		return memberDAO.findOne(idMember);
	}

}
