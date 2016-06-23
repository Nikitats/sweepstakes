package com.totalizator.dao.repository;

import com.totalizator.dao.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by home
 */
public interface IUserRepository extends JpaRepository<User, Long> {
	@Query("SELECT DISTINCT u FROM User u WHERE u.username = :username")
	User findByUsername(@Param("username") String username);
	@Query("SELECT DISTINCT u FROM User u")
	List<User> findAll();

	@Query("select case when count(u)>0 then true else false end from User u where u.username = :login")
	boolean checkIfUserExists(@Param("login") String login);
}
