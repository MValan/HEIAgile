package hei.agile.dao;

import java.util.List;

import hei.agile.entity.ClosedDays;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClosedDaysDAO extends JpaRepository<ClosedDays, Long> {
	public List<ClosedDays> findAll();
	
	
	@Query("select c FROM ClosedDays c ORDER BY c.day")
	public List<ClosedDays> findAllOrderByDate();
}
