package hei.agile.service.impl;

import hei.agile.dao.MemberDAO;
import hei.agile.entity.Member;
import hei.agile.service.MemberService;

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
		return memberDAO.findAll();
	}

	@Override
	public Member findOne(long idMember) {
		return memberDAO.findOne(idMember);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean memberAlreadyExist(Member member) {
		List<Member> members = memberDAO.findAll();
		for (Member m : members) {

			if (member.getBirthDateMember().getYear() == m.getBirthDateMember()
					.getYear()
					& member.getBirthDateMember().getMonth() == m
							.getBirthDateMember().getMonth()
					& member.getBirthDateMember().getDay() == m
							.getBirthDateMember().getDay()) {
				if (m.getFirstNameMember().equals(member.getFirstNameMember())
						& m.getLastNameMember().equals(
								member.getLastNameMember())) {
					return true;
				}
			}
		}
		return false;
	}

}
