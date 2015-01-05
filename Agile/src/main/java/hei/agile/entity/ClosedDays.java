package hei.agile.entity;

import java.util.Date;

import javax.persistence.*;


@Entity
public class ClosedDays {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDay;

	@Column(name = "day")
	private Date day;

	public ClosedDays(Date day) {
		super();
		this.day = day;
	}

	public long getIdDay() {
		return idDay;
	}

	public void setIdDay(long idDay) {
		this.idDay = idDay;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public ClosedDays() {
		super();
	}

	
	
}
