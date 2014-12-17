package hei.agile.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;


@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMember;

	@Column(name = "lastNameMember")
	@Pattern(regexp="(\\p{Alpha}|[ '-éèêëîïàâäôöûüç]){2,50}", message="lastNameMember must be a valide name")
	private String lastNameMember;

	@Column(name = "firstNameMember")
	@Pattern(regexp="(\\p{Alpha}|[ '-éèêëîïàâäôöûüç]){2,50}", message="firstNameMember must be a valide name")
	private String firstNameMember;

	@Column(name = "genderMember")
	@NotNull(message="genderMember can't be null")
	@Pattern(regexp="[FM]", message="genderMember must be 'F' or 'M'")
	private String genderMember;

	@Column(name = "birthDateMember")
	@Past(message="birthDateMember must be past")
	@DateTimeFormat(pattern = "dd/MMyyyy")
	private Date birthDateMember;

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="member")
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
