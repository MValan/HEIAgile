package hei.agile.dao;

import hei.agile.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface BookDAO extends JpaRepository<Book,Long>{

    @Query("SELECT b FROM Book b WHERE b.idBook NOT IN (SELECT w.book.idBook FROM Borrow w WHERE w.returned != 1)")
    public List<Book> findAllAvailable();
}