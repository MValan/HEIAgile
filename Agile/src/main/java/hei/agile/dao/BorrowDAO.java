package hei.agile.dao;

import hei.agile.entity.Borrow;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowDAO extends JpaRepository<Borrow,Long>{

    public Borrow findByBook_IdBook(long idBook);

}