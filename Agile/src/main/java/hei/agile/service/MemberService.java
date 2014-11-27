package hei.agile.service;

import hei.agile.entity.Member;

import java.util.List;

public interface MemberService {

	public void saveMember(Member member);

	public List<Member> findAll();

	public Member findOne(long idMember);

	public boolean memberAlreadyExist(Member member);
}
