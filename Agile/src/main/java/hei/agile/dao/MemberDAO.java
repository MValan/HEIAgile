package hei.agile.dao;

import hei.agile.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDAO extends JpaRepository<Member, Long> {

}
