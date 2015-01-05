package hei.agile.entity;

import javax.persistence.*;


@Entity
public class OpenedDays {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDay;

	@Column(name = "day")
	private String day;

	@Column(name = "fromHour")
	private String fromHour;

	@Column(name = "toHour")
	private String toHour;

	public long getIdDay() {
		return idDay;
	}

	public void setIdDay(long idDay) {
		this.idDay = idDay;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getFromHour() {
		return fromHour;
	}

	public void setFromHour(String fromHour) {
		this.fromHour = fromHour;
	}

	public String getToHour() {
		return toHour;
	}

	public void setToHour(String toHour) {
		this.toHour = toHour;
	}

	public OpenedDays(String day, String fromHour, String toHour) {
		super();
		this.day = day;
		this.fromHour = fromHour;
		this.toHour = toHour;
	}

	public OpenedDays() {
		super();
	}

	
	
}
