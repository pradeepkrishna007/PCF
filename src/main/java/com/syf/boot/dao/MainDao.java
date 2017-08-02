/**
 * 
 */
package com.syf.boot.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.syf.boot.model.User;

/**
 * @author PRADEEP KUMAR
 *
 */
@Repository
public interface MainDao extends CrudRepository<User, Long> {

	// user query example and return a stream
	@Query("select u from User u where u.email = :email")
	Stream<User> findByEmailReturnStream(@Param("email") String email);

	// user query example and return a stream
	@Query("select u from User u where u.username = :username and u.password=:password")
	User getDetails(@Param("username") String username, @Param("password") String password);
}

