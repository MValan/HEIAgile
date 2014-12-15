package hei.agile.dao;

import hei.agile.entity.Borrow;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BorrowDAO extends JpaRepository<Borrow, Long> {

	public Borrow findByBook_IdBook(long idBook);

	public List<Borrow> findByMember_IdMember(long idMember);

	@Modifying(clearAutomatically = true)
	@Query("update Borrow b set b.returned = 1 WHERE b.idBorrow = :idBorrow")
	public void setBorrowToReturned(@Param("idBorrow") Long idBorrow);
}