package hei.agile.dao;

import hei.agile.entity.Membre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreDAO extends JpaRepository<Membre, Long> {

}
