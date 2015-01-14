package hei.agile.dao;

import java.util.List;

import hei.agile.entity.ClosedDays;
import hei.agile.entity.OpenedDays;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OpenedDaysDAO extends JpaRepository<OpenedDays, Long> {
	public List<OpenedDays> findAll();
	
	@Modifying(clearAutomatically = true)
	@Query("update OpenedDays o set o.fromHour = :fromHour, o.toHour = :toHour WHERE o.day = :day")
	public void updateOpenTime(@Param("fromHour") String fromHour, @Param("toHour") String toHour, @Param("day") String day);
}
