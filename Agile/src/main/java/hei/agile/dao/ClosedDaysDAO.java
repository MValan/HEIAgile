package hei.agile.dao;

import java.util.List;

import hei.agile.entity.ClosedDays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClosedDaysDAO extends JpaRepository<ClosedDays, Long> {
	public List<ClosedDays> findAll();
}
