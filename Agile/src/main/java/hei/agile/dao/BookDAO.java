package hei.agile.dao;

import hei.agile.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book,Long>{

}
