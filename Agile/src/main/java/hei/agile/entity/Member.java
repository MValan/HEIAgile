package hei.agile.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMember;

	@Column(name = "nameMember")
	private String nameMember;

	@Column(name = "nicknameMember")
	private String nicknameMember;

	@Column(name = "genderMember")
	private String genderMember;

	@Column(name = "birthDateMember")
	private Date birthDateMember;

	public Member() {

	}

	public Member(String nameMember, String nicknameMember,
			String genderMember, Date birthDateMember) {

		this.nameMember = nameMember;
		this.nicknameMember = nicknameMember;
		this.genderMember = genderMember;
		this.birthDateMember = birthDateMember;
	}

	public long getIdMember() {
		return idMember;
	}

	public String getNameMember() {
		return nameMember;
	}

	public void setNameMember(String nameMember) {
		this.nameMember = nameMember;
	}

	public String getNicknameMember() {
		return nicknameMember;
	}

	public void setNicknameMember(String nicknameMember) {
		this.nicknameMember = nicknameMember;
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
