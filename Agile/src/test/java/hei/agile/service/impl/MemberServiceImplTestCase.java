package hei.agile.service.impl;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;//On importe en "static" pour pouvoir utiliser les méthodes statiques sans avoir à mettre "Mockito." tout le temps;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import hei.agile.dao.MemberDAO;
import hei.agile.entity.Member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)//On dit d'executer le test avec Mockito
public class MemberServiceImplTestCase {

	//On instancie le servvice manuellement, les dépendances annotées par @Mock y seront injectées
	@InjectMocks
	private MemberServiceImpl memberService;
	
	//memDAO est "mocké", c'est un bouchon auquel on doit donner des comportements
	@Mock
	private MemberDAO memberDAO;
	
	
	@Before//sera executé avant les tests
	public void configureTests(){
		//On déclare un comportement pour memberDAO;
		List<Member> allMembers = Arrays.asList(getMember1(),getMember2());
		//On crée 2 members, on les mets dans une liste.
		//A chaque fois qu'on va appeler findAll() sur memberDAO, le bouchon va renvoyer la liste créée ci-dessus
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
	public void shouldListAll(){
		//WHEN
		List<Member> allMembers = memberService.findAll();
		//THEN
		assertThat(allMembers).hasSize(2);//On utilise la superbe librairie AssertJ qui a plein de méthodes très utiles, voilà des exemples d'assertions
		assertThat(allMembers).extracting("firstNameMember","lastNameMember").containsOnly(tuple("firstNameMember","lastNameMember"),tuple("José","Michu"));
		assertThat(allMembers.get(1).getBirthDateMember()).isAfterYear(1982);
	}
	
	

	private Member getMember1() {
		Date date = new Date(Calendar.THURSDAY);
		Member member = new Member();
		member.setFirstNameMember("firstNameMember");
		member.setLastNameMember("lastNameMember");
		member.setGenderMember("F");
		member.setBirthDateMember(date);
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
}
