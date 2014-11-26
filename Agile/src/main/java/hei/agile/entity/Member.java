package hei.agile.entity;

import java.util.Date;
<<<<<<< HEAD

=======
import java.util.List;

import javax.persistence.CascadeType;
>>>>>>> borrowing_books
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Table;

@Entity
@Table(name = "member")
=======
import javax.persistence.OneToMany;

@Entity
>>>>>>> borrowing_books
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMember;
<<<<<<< HEAD

	@Column(name = "lastNameMember")
	private String lastNameMember;

	@Column(name = "firstNameMember")
	private String firstNameMember;

	@Column(name = "genderMember")
	private String genderMember;

	@Column(name = "birthDateMember")
	private Date birthDateMember;

	public Member() {

	}

	public Member(String lastNameMember, String firstNameMember,
			String genderMember, Date birthDateMember) {

		this.lastNameMember = lastNameMember;
		this.firstNameMember = firstNameMember;
		this.genderMember = genderMember;
		this.birthDateMember = birthDateMember;
	}
=======
	
	@Column (name="nameMember")
	private String nameMember;
	
	@Column (name="nicknameMember")
	private String nicknameMember;
	
	@Column (name="genderMember")
	private Boolean genderMember;
	
	@Column (name="birthDateMember")
	private Date birthDateMember;

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="book")
	private List<Borrow> borrow;
	
	public Member() {
		
		super();
	}

	public Member(String nameMember, String nicknameMember,
			Boolean genderMember, Date birthDateMember) {
		super();
		this.nameMember = nameMember;
		this.nicknameMember = nicknameMember;
		this.genderMember = genderMember;
		this.birthDateMember = birthDateMember;
	}
	
	
>>>>>>> borrowing_books

	public long getIdMember() {
		return idMember;
	}

<<<<<<< HEAD
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
=======
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

	public Boolean getGenderMember() {
		return genderMember;
	}

	public void setGenderMember(Boolean genderMember) {
>>>>>>> borrowing_books
		this.genderMember = genderMember;
	}

	public Date getBirthDateMember() {
		return birthDateMember;
	}

	public void setBirthDateMember(Date birthDateMember) {
		this.birthDateMember = birthDateMember;
	}
}
