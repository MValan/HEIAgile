package hei.agile.service;

import java.util.List;

import hei.agile.entity.Member;

public interface MemberService {
	
	public void saveMember(Member member);

	public List<Member> findAll();

	public Member findOne(long idMember);
}
