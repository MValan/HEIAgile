package hei.agile.entity;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMember;

	@Column(name = "lastNameMember")
	private String lastNameMember;

	@Column(name = "firstNameMember")
	private String firstNameMember;

	@Column(name = "genderMember")
	private String genderMember;

	@Column(name = "birthDateMember")
	private Date birthDateMember;

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="book")
	private List<Borrow> borrow;

	public Member() {

	}

	public Member(String lastNameMember, String firstNameMember,
			String genderMember, Date birthDateMember) {

		this.lastNameMember = lastNameMember;
		this.firstNameMember = firstNameMember;
		this.genderMember = genderMember;
		this.birthDateMember = birthDateMember;
	}


	public long getIdMember() {
		return idMember;
	}

	public String getLastNameMember() {
		return lastNameMember;
	}

	public void setLastNameMember(String lastNameMember) {
		this.lastNameMember = lastNameMember;
	}

	public String getFirstNameMember() {
		return firstNameMember;
	}

	public void setFirstNameMember(String firstNameMember) {
		this.firstNameMember = firstNameMember;
	}

	public String getGenderMember() {
		return genderMember;
	}

	public void setGenderMember(String genderMember) {
		this.genderMember = genderMember;
	}

	public Date getBirthDateMember() {
		return birthDateMember;
	}

	public void setBirthDateMember(Date birthDateMember) {
		this.birthDateMember = birthDateMember;
	}
}
