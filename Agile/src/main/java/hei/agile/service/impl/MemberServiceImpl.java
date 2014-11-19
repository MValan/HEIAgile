package hei.agile.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import hei.agile.dao.MemberDAO;
import hei.agile.entity.Book;
import hei.agile.entity.Member;
import hei.agile.service.MemberService;

@Named
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO membreDAO;

	public void saveMember(Member member) {
		
		membreDAO.save(member);
	}
	
	public List<Member> findAll() {
		return membreDAO.findAll();
	}

}
