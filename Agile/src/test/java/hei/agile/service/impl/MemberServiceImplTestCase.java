package hei.agile.service.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.GregorianCalendar;

import hei.agile.dao.MemberDAO;
import hei.agile.entity.Member;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceImplTestCase {

	@InjectMocks
	private MemberServiceImpl memberService;
	
	@Mock
	private MemberDAO memberDAO;
	
	@Before
	public void configureTests(){
		
		List<Member> allMembers = Arrays.asList(getMember1(),getMember2());
		when(memberDAO.findAll()).thenReturn(allMembers);
	}
	
	@Test
	public void shouldSaveMember() {
		
		//GIVEN
		Member member = getMember1();
		//WHEN
		memberService.saveMember(member);
		//THEN
		verify(memberDAO,times(1)).save(eq(member)); //On vérifie que la méthode save de memberDAO a été appelée une fois avec comme paramètre un objet égal à "member"
	}
	
	@Test
	public void shouldFindAll(){
		
		//WHEN
		List<Member> allMembers = memberService.findAll();
		//THEN
		assertThat(allMembers).hasSize(2);//On utilise la superbe librairie AssertJ qui a plein de méthodes très utiles, voilà des exemples d'assertions
		assertThat(allMembers).extracting("firstNameMember","lastNameMember").containsOnly(tuple("firstNameMember","lastNameMember"),tuple("José","Michu"));
		assertThat(allMembers.get(1).getBirthDateMember()).isAfterYear(1982);
	}
	
	@Test
	public void shouldFindOne(){
		
		Long idMember = getMember1().getIdMember();		
		memberService.findOne(idMember);
		
		verify(memberDAO,times(1)).findOne(eq(idMember));
	}
	
	@Test
	public void shouldMemberAlreadyExist(){
		
		Member member1 = getMember1();
		Member member3 = getMember3();
		
		assertThat(memberService.memberAlreadyExist(member1)).isTrue();
		assertThat(memberService.memberAlreadyExist(member3)).isFalse();
	}
	
	private Member getMember1() {
		
		Member member = new Member();
		member.setFirstNameMember("firstNameMember");
		member.setLastNameMember("lastNameMember");
		member.setGenderMember("F");
		Calendar calendar = new GregorianCalendar(1991, 7,25);
		member.setBirthDateMember(calendar.getTime());
		
		return member;
	}
	
	private Member getMember2() {
		
		Member member = new Member();
		member.setFirstNameMember("José");
		member.setGenderMember("M");
		member.setLastNameMember("Michu");
		Calendar calendar = new GregorianCalendar(1983, 5,12);
		member.setBirthDateMember(calendar.getTime());
		
		return member;
	}
	
	private Member getMember3() {
		
		Member member = new Member();
		member.setFirstNameMember("firstName");
		member.setGenderMember("M");
		member.setLastNameMember("lastName");
		Calendar calendar = new GregorianCalendar(1953, 10,12);
		member.setBirthDateMember(calendar.getTime());
		
		return member;
	}
}
